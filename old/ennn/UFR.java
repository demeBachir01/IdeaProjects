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

public class UFR {
    @Id
    private String idUfr;
    private String nomUfr;
    @OneToMany (mappedBy = "ufr",cascade = CascadeType.ALL)
    private List<Departement> departementList;

}
