package co.simplon.lfpapi.model;

import javax.persistence.*;

public class Favori {
    @Id
    /*@SequenceGenerator(name = "favori_seq_id", allocationSize = 1)*/
    @GeneratedValue(strategy = GenerationType.IDENTITY) //.SEQUENCE, generator = "favori_seq_id")
    private Long id;

    @Column(nullable = false)
    private Long idSteam;

    @Column(nullable = false)
    private String username;

    @OneToMany
    private Player player;
}
