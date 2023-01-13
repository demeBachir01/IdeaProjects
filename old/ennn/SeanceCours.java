package cahier.text.gestioncahierdetexte.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class SeanceCours {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSeanceCours;
    private String heureDeb;
    private String heureFin;
    private Integer restantHeure;
    private Integer cumuleDHeure;
    private String contenue;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dateCours;

    @ManyToOne
    private EC ec;
}
