package cahier.text.gestioncahierdetexte.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Formation {
    @Id
    private String idFormation;
    private String nomFormation;
    private String domaine;
    private String specialite;
    private String mention;
    @OneToMany  (mappedBy = "formation")
    private List<Etudiant> etudiant;
    @ManyToMany (mappedBy = "formation")
    private List<Niveau> niveauList;
    @ManyToOne
    private Departement departement;

}
