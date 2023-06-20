package vn.unigap.java.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "COMPETITION_SEASON")
public class CompetitionSeason {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "COMPETITION_ID")
    private Integer competitionId;

    @Column(name = "SEASON_ID")
    private Integer seasonId;

    @Column(name = "MATCH_UPDATED")
    private Date matchUpdated;

    @Column(name = "MATCH_AVAILABLE")
    private Date matchAvailable;
}
