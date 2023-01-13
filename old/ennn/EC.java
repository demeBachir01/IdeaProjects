package cahier.text.gestioncahierdetexte.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EC {
    @Id
    private  String idEC;
    private String nomEc;
    @ManyToOne
    private UE ue;
    @ManyToMany
    private List<Etudiant> etudiant;
    @ManyToOne
    private Enseignant enseignant;
    @OneToMany (mappedBy = "ec", cascade = CascadeType.ALL)
    private List<SeanceCours> seanceCour;
}
