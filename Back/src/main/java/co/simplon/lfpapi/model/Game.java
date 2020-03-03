package co.simplon.lfpapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Game {
    @Id
    /*@SequenceGenerator(name = "game_seq_id", allocationSize = 1)*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long idSteam;

    @Column(nullable = false)
    private String nameGame;

    @Column(nullable = false, name = "img_url_game")
    private String imageUrlGame;

    @OneToMany
    @JoinTable(
            name = "game_sessions",
            joinColumns = @JoinColumn(name="game_idx"),
            inverseJoinColumns = @JoinColumn(name="session_idx")
    )
    private Set<Session> sessions;


    public Long getId() {
        return id;
    }

    public Long getIdSteam() {
        return idSteam;
    }

    public String getNameGame() {
        return nameGame;
    }

    public String getImageUrlGame() {
        return imageUrlGame;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdSteam(Long idSteam) {
        this.idSteam = idSteam;
    }

    public void setNameGame(String nameGame) {
        this.nameGame = nameGame;
    }

    public void setImageUrlGame(String imageUrlGame) {
        this.imageUrlGame = imageUrlGame;
    }
}
