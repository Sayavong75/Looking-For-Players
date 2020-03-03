package co.simplon.lfpapi.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date dateOfGamingSession;

    @ManyToOne
    private Game game;

    //Relation unidirectionnelle donc rien à mettre dans la class Session
    /*@ManyToMany(mappedBy = "sessions")
    private Set<Player> players;*/

    @Column
    private Integer rating;



}
