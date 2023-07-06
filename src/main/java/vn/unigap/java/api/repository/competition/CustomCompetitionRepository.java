package vn.unigap.java.api.repository.competition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.unigap.java.api.dto.in.GetStandingsDtoIn;
import vn.unigap.java.api.dto.out.ListDtoOut;
import vn.unigap.java.api.dto.out.StandingsDtoOut;

import java.util.List;

@Repository
public class CustomCompetitionRepository {
	private final NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public CustomCompetitionRepository(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public ListDtoOut<StandingsDtoOut> getStandings(GetStandingsDtoIn getStandingsDtoIn) {
		List<StandingsDtoOut> standings = jdbcTemplate.query(
				"""
						select a.team_id, a.team_name,
						sum(a.mp) mp, sum(a.win) w, sum(a.draw) d, sum(a.lose) l, sum(a.point) pts,
						sum(a.gf) gf, sum(a.ga) ga, sum(a.gd) gd
						from (
							select *
							from
							(
							select b.id team_id, b.name team_name,
							1 mp,
							case when home_score > away_score then 1 else 0 end win,
							case when home_score = away_score then 1 else 0 end draw,
							case when home_score < away_score then 1 else 0 end lose,
							case when home_score > away_score then 3
								 when home_score = away_score then  1
								 else 0
							end point,
							home_score gf,
							away_score ga,
							home_score - away_score gd
							from `match` a
							inner join team b on a.home_team_id = b.id
							where a.season_id = :season_id
							and a.competition_id = :competition_id
							) a
							union all
							(
							select b.id team_id, b.name team_name,
							1 mp,
							case when home_score < away_score then 0 else 1 end win,
							case when home_score = away_score then 1 else 0 end draw,
							case when home_score > away_score then 1 else 0 end lose,
							case when home_score < away_score then 3
								 when home_score = away_score then  1
								 else 0
							end point,
							away_score gf,
							home_score ga,
							away_score - home_score gd
							from `match` a
							inner join team b on a.away_team_id = b.id
							where a.season_id = :season_id
							and a.competition_id = :competition_id
							)
						) a
						group by a.team_id, a.team_name
						order by pts desc, gd desc, gf desc
						""",
				new MapSqlParameterSource()
						.addValue("season_id", getStandingsDtoIn.getSeasonId())
						.addValue("competition_id", getStandingsDtoIn.getCompetitionId()),
				(rs, rowNum) -> StandingsDtoOut.builder()
						.teamId(rs.getInt("team_id"))
						.teamName(rs.getString("team_name"))
						.mp(rs.getInt("mp"))
						.w(rs.getInt("w"))
						.d(rs.getInt("d"))
						.l(rs.getInt("l"))
						.gf(rs.getInt("gf"))
						.ga(rs.getInt("ga"))
						.gd(rs.getInt("gd"))
						.pts(rs.getInt("pts"))
						.build()
		);

		return ListDtoOut.<StandingsDtoOut>builder()
				.data(standings)
				.build();
	}
}
