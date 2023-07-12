package vn.unigap.java.api.repository.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.unigap.java.api.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
