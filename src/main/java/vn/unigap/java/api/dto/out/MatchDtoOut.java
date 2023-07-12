package vn.unigap.java.api.dto.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchDtoOut {
	private Integer id;
	private Integer homeTeamId;
	private String homeTeamName;
	private Integer awayTeamId;
	private String awayTeamName;
	private Integer homeScore;
	private Integer awayScore;
	private String matchDate;
	private String kickOff;
	public CompetitionDtoOut competition;
	public SeasonDtoOut season;
	public StadiumDtoOut stadium;
	public List<ManagerDtoOut> homeTeamManagers;
	public List<ManagerDtoOut> awayTeamManagers;
	public List<PlayerDtoOut> homeTeamLineups;
	public List<PlayerDtoOut> awayTeamLineups;
}
