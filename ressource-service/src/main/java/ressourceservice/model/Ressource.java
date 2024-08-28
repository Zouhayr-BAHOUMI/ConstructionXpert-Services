package ressourceservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ressourceservice.enums.Type;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ressources")
public class Ressource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRessource;

    @Column(name = "nomRessource", nullable = false)
    private String nomRessource;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "quantite", nullable = false)
    private int quantite;

    @Column(name = "nom_fournisseur", nullable = false)
    private String nomFournisseur;

    @Column(name = "prenom_fournisseur", nullable = false)
    private String prenomFournisseur;

    @Column(name = "tele", nullable = false)
    private String tele;

    @Column(name = "adresse", nullable = false)
    private String adresse;

    @Column(name = "id_tache", nullable = false)
    private int idTache;
}
