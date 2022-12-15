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

public class UFR {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUfr;
    private String nomUfr;
    @OneToMany (mappedBy = "ufr")
    private List<Departement> departementList;

}
