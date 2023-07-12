package vn.unigap.java.api.repository.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.unigap.java.api.dto.out.PlayerDtoOut;

import java.util.List;

@Repository
public class CustomPlayerRepository {
	private final NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public CustomPlayerRepository(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<PlayerDtoOut> findByMatchIdAndTeamId(Integer matchId, Integer teamId) {
		return jdbcTemplate.query(
				"""
						select a.*, b.jersey_number 
						from player a
						inner join match_team_player b on a.id = b.player_id
						inner join `match` c on b.match_id = c.id
						inner join team d on b.team_id = d.id
						where c.id = :match_id and d.id = :team_id
						order by b.jersey_number
						""",
				new MapSqlParameterSource()
						.addValue("match_id", matchId)
						.addValue("team_id", teamId),
				(rs, rowNum) -> PlayerDtoOut.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.nickname(rs.getString("nickname"))
						.jerseyNumber(rs.getInt("jersey_number"))
						.build()
		);
	}
}
