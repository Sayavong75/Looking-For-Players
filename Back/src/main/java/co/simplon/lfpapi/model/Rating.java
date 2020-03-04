package co.simplon.lfpapi.model;

import javax.persistence.*;
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
    @NotBlank
    private Integer ratingOfPlayer;
}
