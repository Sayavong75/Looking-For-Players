package co.simplon.lfpapi.service;

import co.simplon.lfpapi.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PlayerService {

    Player getOnePlayer(Long idPlayer);
    List<Player> getAllPlayers();
    Player savePlayer(Long idPlayer, Player player);
    Player createPlayer(Player player);
    void deletePlayer(Long idPlayer);
}
