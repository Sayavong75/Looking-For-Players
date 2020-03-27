package co.simplon.lfpapi.model;

import javax.persistence.*;
import java.util.Set;

@Entity

public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_id_seq")
    @SequenceGenerator(name = "player_id_seq", sequenceName = "player_id_seq", allocationSize = 1)
    private Long id;

    @Column
    private String username;


    @ManyToMany
    private Set<Session> sessions;

    @ManyToMany
    private Set<Game> games;

    // RELATION UNIDIRECTIONNELLE vers Favorite
    @OneToMany
    private Set<Favorite> favorites;

    // RELATION UNIDIRECTIONNELLE vers Rating
    @OneToMany (mappedBy = "evaluatingPlayer", cascade = CascadeType.ALL)
    private Set<Rating> givenRatings;

    @OneToMany (mappedBy = "evaluatedPlayer", cascade = CascadeType.ALL)
    private Set<Rating> receivedRatings;

    // CONSTRUTORs
    public Player() {
    }
        // constructeur permettant de faire le lien avec la classe Rating en passant un objet Player
    public Player(Long id) {
        this.id = id;
    }


    //GETTERS & SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Session> getSessions() {
        return sessions;
    }

    public void setSessions(Set<Session> sessions) {
        this.sessions = sessions;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public Set<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(Set<Favorite> favorites) {
        this.favorites = favorites;
    }

    public Set<Rating> getGivenRatings() {
        return givenRatings;
    }

    public void setGivenRatings(Set<Rating> ratings) {
        this.givenRatings = ratings;
    }

    public Set<Rating> getReceivedRatings() {
        return receivedRatings;
    }

    public void setReceivedRatings(Set<Rating> receivedRatings) {
        this.receivedRatings = receivedRatings;
    }
}
