package vn.unigap.java.api.repository.matchteamplayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.unigap.java.api.entity.MatchTeamPlayer;

import java.util.Optional;

@Repository
public interface MatchTeamPlayerRepository extends JpaRepository<MatchTeamPlayer, Long> {
    Optional<MatchTeamPlayer> findByMatchIdAndTeamIdAndPlayerId(Integer matchId, Integer teamId, Integer playerId);
}
