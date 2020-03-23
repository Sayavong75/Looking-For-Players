package co.simplon.lfpapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_id_seq")
    @SequenceGenerator(name = "game_id_seq", sequenceName = "game_id_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private Long idSteam;

    @Column(nullable = false)
    private String nameGame;

    @Column(nullable = false, name = "img_url_game")
    private String imageUrlGame;

    @JsonIgnore
    @OneToMany
    @JoinTable(
            name = "game_sessions",
            joinColumns = @JoinColumn(name = "game_idx"),
            inverseJoinColumns = @JoinColumn(name = "session_idx")
    )
    private Set<Session> sessions;

    @JsonIgnore
    @ManyToMany(mappedBy = "games")
    private Set<Player> players;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdSteam() {
        return idSteam;
    }

    public void setIdSteam(Long idSteam) {
        this.idSteam = idSteam;
    }

    public String getNameGame() {
        return nameGame;
    }

    public void setNameGame(String nameGame) {
        this.nameGame = nameGame;
    }

    public String getImageUrlGame() {
        return imageUrlGame;
    }

    public void setImageUrlGame(String imageUrlGame) {
        this.imageUrlGame = imageUrlGame;
    }

    public Set<Session> getSessions() {
        return sessions;
    }

    public void setSessions(Set<Session> sessions) {
        this.sessions = sessions;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
