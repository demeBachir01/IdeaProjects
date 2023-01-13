package cahier.text.gestioncahierdetexte.dtos;

import lombok.Data;
import java.util.Date;



@Data
public class EtudiantDTO {
    private Long idEtudiant;
    private String nom;
    private String prenom;
    private Date dateDeNaissance;
    private String lieuDeNaissance;

}
