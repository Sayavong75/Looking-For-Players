package co.simplon.lfpapi.controller;

import co.simplon.lfpapi.model.Game;
import co.simplon.lfpapi.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
@CrossOrigin("*")

public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) { this.gameService = gameService; }

    @GetMapping
    public List<Game> getGames() {
        return gameService.getGames();
    }

    @PostMapping
    public ResponseEntity<Game> addGame(@RequestBody Game gameToAdd) {
        Game savedGame = gameService.addGame(gameToAdd);
        return ResponseEntity.ok(savedGame);
    }

}
