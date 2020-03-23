package co.simplon.lfpapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
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
    @JsonIgnore
    private Set<Session> sessions;

    @ManyToMany
    private Set<Game> games;

    @OneToMany
    private Set<Favorite> favorites;

/*    @OneToMany
    private Set<Rating> ratingsGiven;

    @OneToMany
    private Set<Rating> ratingsReceived;*/

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

/*    public Set<Rating> getRatingsGiven() {
        return ratingsGiven;
    }

    public void setRatingsGiven(Set<Rating> ratingsGiven) {
        this.ratingsGiven = ratingsGiven;
    }

    public Set<Rating> getRatingsReceived() {
        return ratingsReceived;
    }

    public void setRatingsReceived(Set<Rating> ratingsReceived) {
        this.ratingsReceived = ratingsReceived;
    }*/

    public Set<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(Set<Favorite> favorites) {
        this.favorites = favorites;
    }
}
