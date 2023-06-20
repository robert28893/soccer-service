package vn.unigap.java.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "COMPETITION_SEASON_TEAM")
public class CompetitionSeasonTeam {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "COMPETITION_ID")
	private Integer competitionId;

	@Column(name = "SEASON_ID")
	private Integer seasonId;

	@Column(name = "TEAM_ID")
	private Integer teamId;
}
