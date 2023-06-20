package vn.unigap.java.api.repository.match;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.unigap.java.api.entity.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {
}
