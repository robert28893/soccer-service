package vn.unigap.java.api.repository.teammanager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.unigap.java.api.entity.TeamManager;

import java.util.Optional;

@Repository
public interface TeamManagerRepository extends JpaRepository<TeamManager, Long> {
    Optional<TeamManager> findByTeamIdAndManagerId(Integer teamId, Integer managerId);
}
