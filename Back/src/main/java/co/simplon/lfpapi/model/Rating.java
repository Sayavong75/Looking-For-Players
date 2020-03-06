package co.simplon.lfpapi.model;

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
    private Integer ratingGivenByOnePlayerToAnotherPlayer;

    @Column
    @NotNull
    private Integer ratingReceivedByOnePlayerFromAnotherPlayer;

    @ManyToOne
    private Player player;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRatingGivenByOnePlayerToAnotherPlayer() {
        return ratingGivenByOnePlayerToAnotherPlayer;
    }

    public void setRatingGivenByOnePlayerToAnotherPlayer(Integer ratingGivenByOnePlayerToAnotherPlayer) {
        this.ratingGivenByOnePlayerToAnotherPlayer = ratingGivenByOnePlayerToAnotherPlayer;
    }

    public Integer getRatingReceivedByOnePlayerFromAnotherPlayer() {
        return ratingReceivedByOnePlayerFromAnotherPlayer;
    }

    public void setRatingReceivedByOnePlayerFromAnotherPlayer(Integer ratingReceivedByOnePlayerFromAnotherPlayer) {
        this.ratingReceivedByOnePlayerFromAnotherPlayer = ratingReceivedByOnePlayerFromAnotherPlayer;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
