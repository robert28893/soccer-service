package vn.unigap.java.api.repository.stadium;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.unigap.java.api.entity.Stadium;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Integer> {
}
