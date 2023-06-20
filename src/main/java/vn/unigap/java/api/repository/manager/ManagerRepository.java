package vn.unigap.java.api.repository.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.unigap.java.api.entity.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
}
