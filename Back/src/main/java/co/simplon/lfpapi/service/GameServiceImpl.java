package co.simplon.lfpapi.service;

import co.simplon.lfpapi.model.Game;
import co.simplon.lfpapi.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) { this.gameRepository = gameRepository; }

    @Override
    public List<Game> getGames() {
        return gameRepository.findAll();
    }

    @Override
    public Game addGame(Game gameToAdd) {
        return gameRepository.save(gameToAdd);
    }

}
