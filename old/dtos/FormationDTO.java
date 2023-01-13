package cahier.text.gestioncahierdetexte.dtos;


import lombok.Data;


@Data

public class FormationDTO {
    private Long idFormation;
    private String nomFormation;
    private String domaine;
    private String specialite;
    private String mention;
}
