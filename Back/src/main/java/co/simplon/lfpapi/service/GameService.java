package co.simplon.lfpapi.service;

import co.simplon.lfpapi.model.Game;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GameService {

    /**
     * Get the complete list of games.
     *
     * @return the complete list from persistence layer.
     */
    List<Game> getGames();

    Game addGame(Game gameToAdd);

    Game getGame(Long id);

}
