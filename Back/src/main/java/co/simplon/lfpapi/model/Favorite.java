package co.simplon.lfpapi.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "favorite_id_seq")
    @SequenceGenerator(name = "favorite_id_seq", sequenceName = "favorite_id_seq", allocationSize = 1)
    private Long id;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private LocalDate dateOfFavoritePlayerAdded;

    //Relation unidirectionnelle vers Player
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    private Player favoritePlayer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateOfFavoritePlayerAdded() {
        return dateOfFavoritePlayerAdded;
    }

    public void setDateOfFavoritePlayerAdded(LocalDate dateOfFavoritePlayerAdded) {
        this.dateOfFavoritePlayerAdded = dateOfFavoritePlayerAdded;
    }

    public Player getFavoritePlayer() {
        return favoritePlayer;
    }

    public void setFavoritePlayer(Player favoritePlayer) {
        this.favoritePlayer = favoritePlayer;
    }

    @JsonProperty("favoritePlayer")
    public void setFavoritePlayerById (Long favoritePlayerId){
        this.favoritePlayer = new Player(favoritePlayerId);
    }
}