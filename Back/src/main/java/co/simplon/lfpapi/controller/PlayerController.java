package co.simplon.lfpapi.controller;

import co.simplon.lfpapi.model.Player;
import co.simplon.lfpapi.service.PlayerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/player")
@CrossOrigin("http://localhost:4200")
public class PlayerController {

    private PlayerService playerService;

    public PlayerController (PlayerService playerService){
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getPlayersList(){
        return this.playerService.getAllPlayers();
    }

}
