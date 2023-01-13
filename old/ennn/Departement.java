package cahier.text.gestioncahierdetexte.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Departement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepartement;
    private String nomDepartement;
    @ManyToOne
    private UFR ufr;
    @OneToMany (mappedBy = "departement",cascade = CascadeType.ALL)
    private  List<Formation> formationList;
}
