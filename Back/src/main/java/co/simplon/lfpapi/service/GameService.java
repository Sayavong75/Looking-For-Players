package co.simplon.lfpapi.service;

import co.simplon.lfpapi.model.Game;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import co.simplon.lfpapi.exception.EntityNotFoundException;


@Service
public interface GameService {

//    /**
//     * Get the complete list of games.
//     *
//     * @return the complete list from persistence layer.
//     */
//    List<Game> getGames();

    /**
     * Game list retrieval.
     *
     * @param pageNumber the page number to get
     * @param pageSize   the page size to choose
     * @param criteria   the sorting criteria
     * @param direction  the sorting direction
     * @return a page object with aliments
     */
    Page<Game> getGames(Integer pageNumber, Integer pageSize, String criteria, String direction);

    Game addGame(Game gameToAdd);

    /**
     * Get one game with its ID.
     *
     * @param gameId the aliment ID to look for.
     * @return the aliment if ID is found in DB.
     * @throws EntityNotFoundException in case ID is not found in DB.
     */
    Game getGameById(Long gameId) throws EntityNotFoundException;



}
