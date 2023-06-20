package vn.unigap.java.api.repository.referee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.unigap.java.api.entity.Referee;

@Repository
public interface RefereeRepository extends JpaRepository<Referee, Integer> {
}
