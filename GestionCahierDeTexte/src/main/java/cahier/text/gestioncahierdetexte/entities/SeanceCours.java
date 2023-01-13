package cahier.text.gestioncahierdetexte.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class SeanceCours {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSeance;
    private String contenue;
    private Date dateSeance;
    private Date heureDeb;
    private Date heureFin;
    private Integer nbreHeure;
    @OneToMany(mappedBy = "seanceCours")
    private Collection<AtomePedagogique> atomePedagogiques;
    @OneToMany(mappedBy = "seanceCours")
    private Collection<EC> ecs;
    @ManyToOne
    private Cohorte cohorte;
    @ManyToOne
    private Groupe groupe;
}
