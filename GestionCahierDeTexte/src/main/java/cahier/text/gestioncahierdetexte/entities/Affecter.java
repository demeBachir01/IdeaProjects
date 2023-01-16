package cahier.text.gestioncahierdetexte.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Affecter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateAffectation;
    @OneToMany(mappedBy = "affecter")
    private Collection<Enseignant> enseignants;
    @ManyToOne
    private Groupe groupe;
    @ManyToOne
    private Cohorte cohorte;
    @OneToMany(mappedBy = "affecter")
    private Collection<SeanceCours> seanceCours;

}
