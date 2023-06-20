package vn.unigap.java.api.repository.competitionstate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.unigap.java.api.entity.CompetitionStage;

@Repository
public interface CompetitionStageRepository extends JpaRepository<CompetitionStage, Integer> {
}
