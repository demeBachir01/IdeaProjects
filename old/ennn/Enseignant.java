package cahier.text.gestioncahierdetexte.entities;

import cahier.text.gestioncahierdetexte.enums.Fonction;
import cahier.text.gestioncahierdetexte.enums.Profil;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Enseignant {
    @Id
    private Integer idEnseignant;
    private String nom;
    private String prenom;
    @Enumerated(EnumType.STRING)
    private Profil profil;
    @Enumerated(EnumType.STRING)
    private Fonction fonction;
    @OneToMany (mappedBy = "enseignant",cascade = CascadeType.ALL)
    private List<EC> ec;
}
