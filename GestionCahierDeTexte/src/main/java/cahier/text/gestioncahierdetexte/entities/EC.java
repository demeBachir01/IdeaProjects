package cahier.text.gestioncahierdetexte.entities;

import jakarta.persistence.*;
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
    private List<Etudiant> etudiantListUE;
    @ManyToOne
    private Enseignant enseignant;
    @OneToMany (mappedBy = "EC")
    private List<SeanceCours> seanceCoursList;
}
