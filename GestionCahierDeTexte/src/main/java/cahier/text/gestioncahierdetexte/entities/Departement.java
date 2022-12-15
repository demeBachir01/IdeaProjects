package cahier.text.gestioncahierdetexte.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Departement {
    @Id
    private String idDepartement;
    private String nomDepartement;
    @ManyToOne
    private UFR ufr;
    @OneToMany (mappedBy = "departement")
    private  List<Formation> formationList;
}
