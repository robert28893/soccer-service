package vn.unigap.java.api.repository.match;

import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.unigap.java.api.dto.out.*;
import vn.unigap.java.common.Common;
import vn.unigap.java.common.Constants;
import vn.unigap.java.common.errorcode.ErrorCode;
import vn.unigap.java.common.exception.ApiException;

import java.util.List;

@Repository
public class CustomMatchRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public CustomMatchRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public PageDtoOut<MatchDtoOut> listMatches(Integer competitionId, Integer seasonId, Integer page, Integer pageSize,
                                               Integer teamId) {
        List<MatchDtoOut> matches = jdbcTemplate.query(
                """
                        select a.id, a.home_team_id, d.name home_team_name,
                        a.away_team_id, e.name away_team_name,
                        a.home_score, a.away_score, a.match_date, a.kick_off
                        from `match` a
                        inner join competition b on a.competition_id = b.id
                        inner join season c on a.season_id = c.id
                        inner join team d on a.home_team_id = d.id
                        inner join team e on a.away_team_id = e.id
                        where b.id = :competitionId
                        and c.id = :seasonId
                        and (d.id = coalesce(:teamId, d.id) or e.id = coalesce(:teamId, e.id))
                        order by a.match_date desc, a.kick_off desc
                        limit :limit offset :offset
                        """,
                new MapSqlParameterSource()
                        .addValue("competitionId", competitionId)
                        .addValue("seasonId", seasonId)
                        .addValue("teamId", teamId)
                        .addValue("limit", pageSize)
                        .addValue("offset", (page - 1) * pageSize),
                (rs, rowNum) -> MatchDtoOut.builder()
                        .id(rs.getInt("id"))
                        .homeTeamId(rs.getInt("home_team_id"))
                        .homeTeamName(rs.getString("home_team_name"))
                        .homeScore(rs.getInt("home_score"))
                        .awayTeamId(rs.getInt("away_team_id"))
                        .awayTeamName(rs.getString("away_team_name"))
                        .awayScore(rs.getInt("away_score"))
                        .matchDate(Common.dateToString(rs.getDate("match_date"), Constants.DTF_MATCH_DATE))
                        .kickOff(Common.timeToString(rs.getTime("kick_off"), Constants.DTF_KICK_OFF))
                        .build());

        Long totalElements = jdbcTemplate.queryForObject(
                """
                        select count(1)
                        from `match` a
                        inner join competition b on a.competition_id = b.id
                        inner join season c on a.season_id = c.id
                        inner join team d on a.home_team_id = d.id
                        inner join team e on a.away_team_id = e.id
                        where b.id = :competitionId
                        and c.id = :seasonId
                        and (d.id = coalesce(:teamId, d.id) or e.id = coalesce(:teamId, e.id))
                        """,
                new MapSqlParameterSource()
                        .addValue("competitionId", competitionId)
                        .addValue("seasonId", seasonId)
                        .addValue("teamId", teamId),
                Long.class
        );

        return PageDtoOut.from(page, pageSize, totalElements, matches);
    }

    public MatchDtoOut findById(Integer id) {
        List<MatchDtoOut> matches = jdbcTemplate.query(
                """
                        select a.id, a.home_team_id, d.name home_team_name,
                        a.away_team_id, e.name away_team_name,
                        a.home_score, a.away_score, a.match_date, a.kick_off, 
                        b.id competition_id, b.name competition_name,
                        c.id season_id, c.name season_name,
                        f.id stadium_id, f.name stadium_name,
                        g.id referee_id, g.name referee_name
                        from `match` a
                        inner join competition b on a.competition_id = b.id
                        inner join season c on a.season_id = c.id
                        inner join team d on a.home_team_id = d.id
                        inner join team e on a.away_team_id = e.id
                        left join stadium f on a.stadium_id = f.id
                        left join referee g on a.referee_id = g.id
                        where a.id = :id
                        """,
                new MapSqlParameterSource()
                        .addValue("id", id),
                (rs, rowNum) -> MatchDtoOut.builder()
                        .id(rs.getInt("id"))
                        .homeTeamId(rs.getInt("home_team_id"))
                        .homeTeamName(rs.getString("home_team_name"))
                        .homeScore(rs.getInt("home_score"))
                        .awayTeamId(rs.getInt("away_team_id"))
                        .awayTeamName(rs.getString("away_team_name"))
                        .awayScore(rs.getInt("away_score"))
                        .matchDate(Common.dateToString(rs.getDate("match_date"), Constants.DTF_MATCH_DATE))
                        .kickOff(Common.timeToString(rs.getTime("kick_off"), Constants.DTF_KICK_OFF))
                        .competition(CompetitionDtoOut.builder()
                                .id(rs.getInt("competition_id"))
                                .name(rs.getString("competition_name"))
                                .build())
                        .season(SeasonDtoOut.builder()
                                .id(rs.getInt("season_id"))
                                .name(rs.getString("season_name"))
                                .build())
                        .stadium(StadiumDtoOut.builder()
                                .id(rs.getInt("stadium_id"))
                                .name(rs.getString("stadium_name"))
                                .build())
                        .referee(RefereeDtoOut.builder()
                                .id(rs.getInt("referee_id"))
                                .name(rs.getString("referee_name"))
                                .build())
                        .build());

        if (matches.isEmpty()) {
            throw new ApiException(ErrorCode.NOT_FOUND, HttpStatus.NOT_FOUND, String.format("match not found: %s", id));
        }

        return matches.get(0);
    }
}
