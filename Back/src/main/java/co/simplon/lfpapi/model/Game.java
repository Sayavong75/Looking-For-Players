package co.simplon.lfpapi.model;

import javax.persistence.*;

@Entity
public class Game {
    @Id
    @SequenceGenerator(name = "game_seq_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_seq_id")
    private Long id;

    @Column(nullable = false)
    private String idSteam;

    @Column(nullable = false)
    private String nameGame;

    @Column(nullable = false)
    private String imageUrlGame;

    public Long getId() {
        return id;
    }

    public String getIdSteam() {
        return idSteam;
    }

    public String getNameGame() {
        return nameGame;
    }

    public String getImageUrlGame() {
        return imageUrlGame;
    }

}
