package com.gogp.gp.modele;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voyage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVoyage;

    @Column(length = 50, nullable = false)
    private String flightTicketURL;

    @Column(length = 50, nullable = false)
    private String paysdepart;

    @Column(length = 50, nullable = false, unique = true)
    private String paysarrive;

    @Column(length = 50, nullable = false)
    private Integer numberOfKg;

    @Column(length = 50, nullable = false)
    private Float prixkg;

    @Column(length = 50, nullable = false)
    private Date departureDate;

    @Column(length = 50, nullable = false)
    private Date arrivalDate;

}
