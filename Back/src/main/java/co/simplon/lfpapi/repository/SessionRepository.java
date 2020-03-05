package co.simplon.lfpapi.repository;

import co.simplon.lfpapi.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long> {

    @Query("SELECT s FROM Session s join s.players p where p.id = :idPlayer")
    public List<Session> getSessionsByPlayerId(@Param("idPlayer") Long idPlayer);
}
