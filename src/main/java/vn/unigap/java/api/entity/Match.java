package vn.unigap.java.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "MATCH")
public class Match {
	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "MATCH_DATE")
	private Date matchDate;

	@Column(name = "KICK_OFF")
	private Time kickOff;

	@Column(name = "COMPETITION_ID")
	private Integer competitionId;

	@Column(name = "SEASON_ID")
	private Integer seasonId;

	@Column(name = "HOME_TEAM_ID")
	private Integer homeTeamId;

	@Column(name = "AWAY_TEAM_ID")
	private Integer awayTeamId;

	@Column(name = "HOME_SCORE")
	private Integer homeScore;

	@Column(name = "AWAY_SCORE")
	private Integer awayScore;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "LAST_UPDATED")
	private Date lastUpdated;

	@Column(name = "METADATA")
	private String metadata;

	@Column(name = "WEEK")
	private Integer week;

	@Column(name = "COMPETITION_STAGE_ID")
	private Integer competitionStageId;

	@Column(name = "STADIUM_ID")
	private Integer stadiumId;

	@Column(name = "REFEREE_ID")
	private Integer refereeId;
}
