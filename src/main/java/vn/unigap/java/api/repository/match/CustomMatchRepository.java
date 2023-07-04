package vn.unigap.java.api.repository.match;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.unigap.java.api.dto.out.ListDtoOut;
import vn.unigap.java.api.dto.out.MatchDtoOut;
import vn.unigap.java.common.Common;
import vn.unigap.java.common.Constants;

import java.util.List;

@Repository
public class CustomMatchRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public CustomMatchRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ListDtoOut<MatchDtoOut> listMatches(Integer competitionId, Integer seasonId) {
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
                        order by a.match_date desc, a.kick_off desc
                        """,
                new MapSqlParameterSource()
                        .addValue("competitionId", competitionId)
                        .addValue("seasonId", seasonId),
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

        return ListDtoOut.<MatchDtoOut>builder().data(matches).build();
    }
}
