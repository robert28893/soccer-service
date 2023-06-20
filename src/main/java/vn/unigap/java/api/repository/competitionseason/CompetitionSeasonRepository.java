package vn.unigap.java.api.repository.competitionseason;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.unigap.java.api.entity.CompetitionSeason;

import java.util.Optional;

@Repository
public interface CompetitionSeasonRepository extends JpaRepository<CompetitionSeason, Long> {
	Optional<CompetitionSeason> findByCompetitionIdAndSeasonId(Integer competitionId, Integer seasonId);
}
