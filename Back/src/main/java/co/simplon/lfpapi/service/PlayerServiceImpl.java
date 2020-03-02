package co.simplon.lfpapi.service;

import co.simplon.lfpapi.model.Player;
import co.simplon.lfpapi.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;

    public PlayerServiceImpl (PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    @Override
    public Player getOnePlayer(Long id){
        return playerRepository.getOne(id);
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
}
