package vn.unigap.java.api.repository.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.unigap.java.api.entity.Manager;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {

	@Query(
			value = """
					select a.*
					from manager a
					inner join match_team_manager b on a.id = b.manager_id
					inner join `match` c on b.match_id = c.id
					inner join team d on b.team_id = d.id
					where c.id = :match_id and d.id = :team_id
					""",
			nativeQuery = true
	)
	List<Manager> findByMatchIdAndTeamId(
			@Param(value = "match_id") Integer matchId,
			@Param(value = "team_id") Integer teamId);
}
