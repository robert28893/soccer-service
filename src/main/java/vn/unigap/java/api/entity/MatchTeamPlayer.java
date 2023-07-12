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
@Table(name = "MATCH_TEAM_PLAYER")
public class MatchTeamPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "MATCH_ID")
    private Integer matchId;

    @Column(name = "TEAM_ID")
    private Integer teamId;

    @Column(name = "PLAYER_ID")
    private Integer playerId;

    @Column(name = "JERSEY_NUMBER")
    private Integer jerseyNumber;
}
