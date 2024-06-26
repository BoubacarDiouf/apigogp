package com.gogp.gp.modele;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Colis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer quantite;

    @Column(length = 50, nullable = false)
    private String description;

    @Column
    private Double poids; // Poids du colis, peut être null si non pesable

    @Column(length = 50, nullable = false)
    private String statut; // Statut du colis

    @Column(length = 3, nullable = false)
    private String pesable; // Indique si le colis est pesable ou non (accepte "oui" ou "non")
}
