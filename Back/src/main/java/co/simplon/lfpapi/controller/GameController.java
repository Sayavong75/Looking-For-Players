package co.simplon.lfpapi.controller;

import co.simplon.lfpapi.model.Favorite;
import co.simplon.lfpapi.model.Game;
import co.simplon.lfpapi.model.Player;
import co.simplon.lfpapi.repository.GameRepository;
import co.simplon.lfpapi.service.GameService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/games")
@CrossOrigin("http://localhost:4200")

public class GameController {

    private GameService gameService;
    private GameRepository gameRepository;

    public GameController(GameService gameService) { this.gameService = gameService; }

    /*
     * Controller method enabling Aliment list retrieval with pagination and sorting.
     *
     * @param pageNumber the page number we want to get (default is 0)
     * @param pageSize   the page size we want to define (default is 50)
     * @param criteria   the sorting criteria (default is aliment name)
     * @param direction  the sorting direction (default is ascending)
     * @return a Page object containing Aliments.
     */

//    @GetMapping
//    public Page<Game> getGames(
//            @Valid @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
//            @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
//            @Valid @RequestParam(value = "sort", required = false) String criteria,
//            @Valid @RequestParam(value = "direction", required = false) String direction) {
//
//        return gameService.getGames(pageNumber, pageSize, criteria, direction);
//    }

    @GetMapping
    public List<Game> getGames() { return this.gameService.getGames();}

    @PostMapping
    public ResponseEntity<Game> addGame(@RequestBody Game gameToAdd) {
        Game savedGame = gameService.addGame(gameToAdd);
        return ResponseEntity.ok(savedGame);
    }

    @GetMapping("/{gameId}")
    public Game getGame(@PathVariable Long gameId) {
        return this.gameService.getGameById(gameId);
    }

}
