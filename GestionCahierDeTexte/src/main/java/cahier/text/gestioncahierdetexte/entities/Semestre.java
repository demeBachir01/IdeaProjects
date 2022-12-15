package cahier.text.gestioncahierdetexte.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Semestre {
    @Id
    private String idSemestre;
    private String nomSemestre;
    private String annee;
    @OneToMany (mappedBy = "semestre")
    private List<UE> ueList;
    @ManyToOne
    private AnneScolaire anneScolaire;
}
