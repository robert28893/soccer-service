package vn.unigap.java.api.repository.competition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.unigap.java.api.entity.Competition;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Integer> {
}
