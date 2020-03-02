package co.simplon.lfpapi.repository;

import co.simplon.lfpapi.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
