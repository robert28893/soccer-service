package vn.unigap.java.api.repository.season;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.unigap.java.api.entity.Season;

import java.util.List;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Integer> {
    @Query(
            value = """
                    select a.*
                    from season a
                    inner join competition_season b on a.id = b.season_id
                    inner join competition c on b.competition_id = c.id
                    where 1=1
                    and c.id = :competitionId
                    order by a.name desc""",
            nativeQuery = true
    )
    List<Season> findByCompetitionId(@Param(value = "competitionId") Integer competitionId);
}
