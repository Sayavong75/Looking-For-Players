package co.simplon.lfpapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(value = {"evaluatedPlayer"})
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_id_seq")
    @SequenceGenerator(name = "player_id_seq", sequenceName = "player_id_seq", allocationSize = 1)
    private Long id;

    @Column
    private String username;

    @JsonIgnore
    @ManyToMany (mappedBy = "players")
    private Set<Session> sessions;

    @ManyToMany
    private Set<Game> games;

    @OneToMany
    private Set<Favorite> favorites;

    /*@JsonBackReference*/
    @OneToMany /*(mappedBy ="evaluatingPlayer", cascade = CascadeType.ALL)*/
    private Set<Rating> ratings;

   /* @JsonIgnore
    @OneToMany (mappedBy = "evaluatedPlayer")
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

    public Set<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(Set<Favorite> favorites) {
        this.favorites = favorites;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

/*    public Set<Rating> getRatingsReceived() {
        return ratingsReceived;
    }

    public void setRatingsReceived(Set<Rating> ratingsReceived) {
        this.ratingsReceived = ratingsReceived;
    }*/
}
