package co.simplon.lfpapi.service;

import co.simplon.lfpapi.exception.EntityNotFoundException;
import co.simplon.lfpapi.model.Favorite;
import co.simplon.lfpapi.repository.FavoriteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    private FavoriteRepository favoriteRepository;

    public FavoriteServiceImpl(FavoriteRepository favoriteRepository) { this.favoriteRepository = favoriteRepository; }

    @Override
    public List<Favorite> getAllFavorites() {
        return favoriteRepository.findAll();
    }

    @Override
    public Favorite addFavorite(Favorite favoriteToAdd) {
        return favoriteRepository.save(favoriteToAdd);
    }

    @Override
    public Favorite getFavoriteById(Long favoriteId) throws EntityNotFoundException {
        Optional<Favorite> dbFavorite = favoriteRepository.findById(favoriteId);

        if (dbFavorite.isPresent()) {
            return dbFavorite.get();
        } else {
            throw new EntityNotFoundException("The aliment with ID: " + favoriteId + " cannot be found in DB", "Game");
        }
    }
    @Override
    public void deleteFavorite(Long favoriteId) {
        this.favoriteRepository.deleteById(favoriteId);
    }
}
