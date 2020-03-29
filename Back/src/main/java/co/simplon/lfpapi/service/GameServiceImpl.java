package co.simplon.lfpapi.service;

import co.simplon.lfpapi.model.Favorite;
import co.simplon.lfpapi.model.Game;
import co.simplon.lfpapi.repository.GameRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import co.simplon.lfpapi.exception.EntityNotFoundException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    private GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) { this.gameRepository = gameRepository; }

//    @Override
//    public List<Game> getGames() {
//        return gameRepository.findAll();
//    }

//    @Override
//    public Page<Game> getGames(Integer pageNumber, Integer pageSize, String criteria, String direction) {
//        // If page number is not null then use it for paging, otherwise provide page 0
//        int pNumber = (pageNumber != null) ? pageNumber : 0;
//        // If page size is not null then use it for paging, otherwise use default 50 page size
//        int pSize = (pageSize != null) ? pageSize : 50;
//
//        // By default sort on game name
//        String sortingCriteria = "name";
//
//        // If sorting criteria matches an aliment field name, then use it for sorting
//        Field[] fields = Game.class.getDeclaredFields();
//        List<String> possibleCriteria = new ArrayList<>();
//        for (Field field : fields) {
//            possibleCriteria.add(field.getName().toLowerCase());
//        }
//        if (criteria != null && possibleCriteria.contains(criteria)) {
//            sortingCriteria = criteria;
//        }
//
//        // By default sorting ascending, but if user explicitely choose desc, then sort descending
//        Sort.Direction sortingDirection = Sort.Direction.ASC;
//        if (direction != null) {
//            sortingDirection = direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
//        }
//
//        return gameRepository.findAll(PageRequest.of(pNumber, pSize, Sort.by(sortingDirection, sortingCriteria)));
//    }
//
    @Override
    public List<Game> getGames() {
        return gameRepository.findAll();
    }

    @Override
    public Game addGame(Game gameToAdd) {
        return gameRepository.save(gameToAdd);
    }

    @Override
    public Game getGameById(Long gameId) throws EntityNotFoundException {
        Optional<Game> dbGame = gameRepository.findById(gameId);

        if (dbGame.isPresent()) {
            return dbGame.get();
        } else {
            throw new EntityNotFoundException("The aliment with ID: " + gameId + " cannot be found in DB", "Game");
        }
    }

}
