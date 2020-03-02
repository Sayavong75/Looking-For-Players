package co.simplon.lfpapi.controller;

import co.simplon.lfpapi.model.Game;
import co.simplon.lfpapi.service.GameService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
