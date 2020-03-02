package co.simplon.lfpapi.controller;

import co.simplon.lfpapi.model.Game;
import co.simplon.lfpapi.repository.GameRepository;
import co.simplon.lfpapi.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/games")
@CrossOrigin("*")

public class GameController {

    private GameService gameService;
    private GameRepository gameRepository;

    public GameController(GameService gameService) { this.gameService = gameService; }

    @GetMapping
    public List<Game> getGames() {
        return gameService.getGames();
    }

    @PostMapping("/addGame")
    public ResponseEntity<Game> addGame(@RequestBody Game gameToAdd) {
        Game savedGame = gameService.addGame(gameToAdd);
        return ResponseEntity.ok(savedGame);
    }

    @GetMapping("/{id}")
    public Game getGame(@PathVariable Long id) {
        return this.gameService.getGame(id);
    }

}
