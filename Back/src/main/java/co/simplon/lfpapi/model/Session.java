package co.simplon.lfpapi.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "session_id_seq")
    @SequenceGenerator(name = "session_id_seq", sequenceName = "session_id_seq", allocationSize = 1)
    private Long id;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private Date dateOfGamingSession;

    //Relation bidirectionnelle
    @ManyToOne
    private Game game;

    //Relation bidirectionnelle vers Player.
    // Session est l'esclave du maitre Player c'est pourquoi on met le mappedBy ici
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("playersId")
    @ManyToMany (mappedBy = "sessions")
    private Set<Player> players;

    //ACCESSORS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOfGamingSession() {
        return dateOfGamingSession;
    }

    public void setDateOfGamingSession(Date dateOfGamingSession) {
        this.dateOfGamingSession = dateOfGamingSession;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
