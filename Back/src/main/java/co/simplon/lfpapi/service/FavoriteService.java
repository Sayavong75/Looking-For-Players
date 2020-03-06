package co.simplon.lfpapi.service;

import co.simplon.lfpapi.exception.EntityNotFoundException;
import co.simplon.lfpapi.model.Favorite;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FavoriteService {

    List<Favorite> getAllFavorites();
    Favorite addFavorite(Favorite favoriteToAdd);
    Favorite getFavoriteById(Long favoriteId) throws EntityNotFoundException;
    void deleteFavorite(Long favoriteId);

}
