package co.simplon.lfpapi.controller;

import co.simplon.lfpapi.model.Favorite;
import co.simplon.lfpapi.model.Game;
import co.simplon.lfpapi.repository.FavoriteRepository;
import co.simplon.lfpapi.service.FavoriteService;
import org.springframework.http.ResponseEntity;
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
    public List<Favorite> getFavoritesList(){
        return this.favoriteService.getAllFavorites();
    }

    @GetMapping("/{favoriteId}")
    public Favorite getFavorite(@PathVariable Long favoriteId) {
        return this.favoriteService.getFavoriteById(favoriteId);
    }

    @PostMapping
    public ResponseEntity<Favorite> addFavorite(@RequestBody Favorite favoriteToAdd) {
        Favorite savedFavorite = favoriteService.addFavorite(favoriteToAdd);
        return ResponseEntity.ok(savedFavorite);
    }

    @DeleteMapping("/{favoriteId}")
    public void deleteFavorite(@PathVariable Long favoriteId){
        this.favoriteService.deleteFavorite(favoriteId);
    }

}
