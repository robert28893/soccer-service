package vn.unigap.java.api.repository.competitionseasonteam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.unigap.java.api.entity.CompetitionSeasonTeam;

import java.util.Optional;

@Repository
public interface CompetitionSeasonTeamRepository extends JpaRepository<CompetitionSeasonTeam, Integer> {
	Optional<CompetitionSeasonTeam> findByCompetitionIdAndSeasonIdAndTeamId(Integer competitionId, Integer seasonId, Integer teamId);
}
