package cahier.text.gestioncahierdetexte.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Semestre {
    @Id
    private String idSemestre;
    private String nomSemestre;
    private String annee;
    @OneToMany (mappedBy = "semestre",cascade = CascadeType.ALL)
    private List<UE> ueList;
    @ManyToOne
    private AnneScolaire anneScolaire;
}
