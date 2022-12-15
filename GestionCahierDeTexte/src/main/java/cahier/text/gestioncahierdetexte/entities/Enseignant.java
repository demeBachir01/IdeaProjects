package cahier.text.gestioncahierdetexte.entities;

import cahier.text.gestioncahierdetexte.enums.Fonction;
import cahier.text.gestioncahierdetexte.enums.Profil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Enseignant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnseignant;
    private String nom;
    private String prenom;
    private Profil profil;
    private Fonction fonction;
    @OneToMany (mappedBy = "ecListEnseignant")
    private List<EC> ecListEnseignant;
}
