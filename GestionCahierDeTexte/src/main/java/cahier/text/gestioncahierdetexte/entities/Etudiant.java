package cahier.text.gestioncahierdetexte.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Entity
@Data  @NoArgsConstructor @AllArgsConstructor
public class Etudiant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;
    private String nom;
    private String prenom;
    private Date dateDeNaissance;
    private String lieuDeNaissance;
    @ManyToOne
    private Formation formation;
    @ManyToMany (mappedBy = "etudiantListUE")
    private List<EC> ecList;

}
