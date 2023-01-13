package cahier.text.gestioncahierdetexte.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


@Data



public class SeanceCoursDTO {
    private Long numSeanceCours;
    private String heureDeb;
    private String heureFin;
    private String contenue;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dateCours;
    
}
