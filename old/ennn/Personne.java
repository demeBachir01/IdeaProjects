package cahier.text.gestioncahierdetexte.entities;

import javax.persistence.*;
import java.util.Collection;
@Entity
public class Personne {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private Integer cni;
    private Integer tel;
    @OneToMany(mappedBy = "personne")
    private Collection<IndividuCompte> individuCompte;
}
