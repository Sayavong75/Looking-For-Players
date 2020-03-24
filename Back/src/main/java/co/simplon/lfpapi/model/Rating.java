package co.simplon.lfpapi.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating_id_seq")
    @SequenceGenerator(name = "rating_id_seq", sequenceName = "rating_id_seq", allocationSize = 1)
    private Long id;

    @Column
    @NotNull
    @Min(value = 0)
    @Max(value = 5)
    private Integer ratingOfAPlayer;

    // Il faut disposer d'un joueur évaluateur et d'un joueur évalué -> regarder à faire plusieurs relations vers l'entité Player

    //EVALUATED PLAYER -- relation unidirectionnelle vers Player
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    private Player evaluatedPlayer;


    // ACCESSORS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRatingOfAPlayer() {
        return ratingOfAPlayer;
    }

    public void setRatingOfAPlayer(Integer ratingOfAPlayer) {
        this.ratingOfAPlayer = ratingOfAPlayer;
    }

    public Player getEvaluatedPlayer() {
        return evaluatedPlayer;
    }

    public void setEvaluatedPlayer(Player evaluatedPlayer) {
        this.evaluatedPlayer = evaluatedPlayer;
    }


}
