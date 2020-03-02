package co.simplon.lfpapi.service;

import co.simplon.lfpapi.model.Game;
import co.simplon.lfpapi.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Game getGame(Long id) {
        return gameRepository.getOne(id);
    }

}
