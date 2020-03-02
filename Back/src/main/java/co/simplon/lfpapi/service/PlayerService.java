package co.simplon.lfpapi.service;

import co.simplon.lfpapi.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerService {

    Player getOnePlayer(Long id);
    List<Player> getAllPlayers();
}
