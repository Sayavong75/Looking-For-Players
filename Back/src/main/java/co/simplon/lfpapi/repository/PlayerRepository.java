package co.simplon.lfpapi.repository;

import co.simplon.lfpapi.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
