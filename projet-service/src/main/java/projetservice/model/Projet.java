package projetservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "projets")
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProjet;

    @Column(name = "nom_projet", nullable = false)
    private String nom_projet;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "date_debut", nullable = false)
    private LocalDate date_debut;

    @Column(name = "date_fin", nullable = false)
    private LocalDate date_fin;

    @Column(name = "budget", nullable = false)
    private String budget;


}
