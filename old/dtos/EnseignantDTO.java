package cahier.text.gestioncahierdetexte.dtos;

import cahier.text.gestioncahierdetexte.enums.Fonction;
import cahier.text.gestioncahierdetexte.enums.Profil;
import lombok.Data;


@Data

public class EnseignantDTO {
    private Integer idEnseignant;
    private String nom;
    private String prenom;
    private Profil profil;
    private Fonction fonction;

}
