package vn.unigap.java.api.repository.season;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.unigap.java.api.entity.Season;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Integer> {
}
