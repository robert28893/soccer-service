package vn.unigap.java.api.repository.matchteammanager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.unigap.java.api.entity.MatchTeamManager;

import java.util.Optional;

@Repository
public interface MatchTeamManagerRepository extends JpaRepository<MatchTeamManager, Long> {
    Optional<MatchTeamManager> findByMatchIdAndTeamIdAndManagerId(Integer matchId, Integer teamId, Integer managerId);
}
