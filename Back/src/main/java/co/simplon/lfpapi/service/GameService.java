package co.simplon.lfpapi.service;

import co.simplon.lfpapi.model.Game;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GameService {

//    /**
//     * Get the complete list of games.
//     *
//     * @return the complete list from persistence layer.
//     */
//    List<Game> getGames();

    /**
     * Aliment list retrieval.
     *
     * @param pageNumber the page number to get
     * @param pageSize   the page size to choose
     * @param criteria   the sorting criteria
     * @param direction  the sorting direction
     * @return a page object with aliments
     */
    Page<Game> getGames(Integer pageNumber, Integer pageSize, String criteria, String direction);

    Game addGame(Game gameToAdd);

    Game getGame(Long id);



}
