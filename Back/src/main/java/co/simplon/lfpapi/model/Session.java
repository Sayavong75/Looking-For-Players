package co.simplon.lfpapi.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOfGamingSession;

    @NotNull
    @NotBlank

    //Relation unidirectionnelle donc rien à mettre dans la class Session
    /*@ManyToOne
    private Game game;*/

    //Relation unidirectionnelle donc rien à mettre dans la class Session
    /*@ManyToMany(mappedBy = "sessions")
    private Set<Player> players;*/

    @NotNull
    @Column
    private Integer rating;



}
