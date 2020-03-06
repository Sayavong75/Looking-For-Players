package co.simplon.lfpapi.repository;

import co.simplon.lfpapi.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
}
