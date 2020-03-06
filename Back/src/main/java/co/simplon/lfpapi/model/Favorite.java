package co.simplon.lfpapi.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "favorite_id_seq")
    @SequenceGenerator(name="favorite_id_seq", sequenceName = "favorite_id_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private Long idPlayer;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private LocalDate dateOfFavoritePlayerAdded;

    @OneToMany(mappedBy = "favorite")
    private Set<Player> players;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(Long idPlayer) {
        this.idPlayer = idPlayer;
    }

    public LocalDate get() {
        return dateOfFavoritePlayerAdded;
    }

    public void setDateOfFavoritePlayerAdded(LocalDate dateOfFavoritePlayerAdded) {
        this.dateOfFavoritePlayerAdded = dateOfFavoritePlayerAdded;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
