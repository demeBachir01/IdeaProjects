package cahier.text.gestioncahierdetexte.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Formation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFormation;
    private String nomFormation;
    private String domaine;
    private String specialite;
    private String mention;
    @OneToMany (mappedBy = "formation", cascade = CascadeType.ALL)
    private List<Etudiant> etudiantList;
    @ManyToMany (mappedBy = "formation",cascade = CascadeType.ALL)
    private List<Niveau> niveau;
    @ManyToOne
    private Departement departement;

    public  void addEtudiant(Etudiant etudiant){
        this.etudiantList.add(etudiant);

    }

}
