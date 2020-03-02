package co.simplon.lfpapi.controller;

import co.simplon.lfpapi.model.Player;
import co.simplon.lfpapi.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{idPlayer}")
    public Player getPlayer(@PathVariable Long idPlayer){
        return this.playerService.getOnePlayer(idPlayer);
    }

    @PutMapping
        public ResponseEntity<Player> updatePlayer(@RequestBody Player player){
        try {
            return ResponseEntity.ok(this.playerService.savePlayer(player));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
        public ResponseEntity<Player> createPlayer (@RequestBody Player player){
        try {
            return ResponseEntity.ok(this.playerService.createPlayer(player));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{idPlayer}")
        public void deletePlayer(@PathVariable Long idPlayer){
        this.playerService.deletePlayer(idPlayer);
    }

}
