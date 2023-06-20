package vn.unigap.java.api.repository.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.unigap.java.api.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
}
