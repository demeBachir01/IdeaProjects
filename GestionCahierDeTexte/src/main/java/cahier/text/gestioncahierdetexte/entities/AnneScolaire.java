package cahier.text.gestioncahierdetexte.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    @OneToMany (mappedBy = "anneScolaire")
    private List<Semestre> semestreList;
}
