package cahier.text.gestioncahierdetexte.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class AnneScolaire {
    @Id
    private  String idAnneeScolaire;
    @OneToMany (mappedBy = "anneScolaire", cascade = CascadeType.ALL)
    private List<Semestre> semestreList;
}
