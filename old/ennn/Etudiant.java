package cahier.text.gestioncahierdetexte.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Entity
@Data  @NoArgsConstructor @AllArgsConstructor
public class Etudiant{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;
    private String nom;
    private String prenom;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dateDeNaissance;
    private String lieuDeNaissance;
    @ManyToOne
    private Formation formation;
    @ManyToMany (mappedBy = "etudiant",cascade = CascadeType.ALL)
    private List<EC> ec;

}
