package co.simplon.lfpapi.controller;

import co.simplon.lfpapi.model.Favorite;
import co.simplon.lfpapi.model.Game;
import co.simplon.lfpapi.model.Player;
import co.simplon.lfpapi.repository.FavoriteRepository;
import co.simplon.lfpapi.repository.GameRepository;
import co.simplon.lfpapi.service.FavoriteService;
import co.simplon.lfpapi.service.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
@CrossOrigin("*")

public class FavoriteController {

    private FavoriteService favoriteService;
    private FavoriteRepository favoriteRepository;

    public FavoriteController(FavoriteService favoriteService) { this.favoriteService = favoriteService; }

    @GetMapping
    public List<Favorite> get(){
        return this.favoriteService.getAllFavorites();
    }

    @GetMapping("/{favoriteId}")
    public Favorite getFavorite(@PathVariable Long favoriteId) {
        return this.favoriteService.getFavoriteById(favoriteId);
    }

}
