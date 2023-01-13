package cahier.text.gestioncahierdetexte.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UE {
    @Id
    private String idUE;
    private String nomUE;
    @OneToMany (mappedBy = "ue" ,cascade = CascadeType.ALL)
    private List<EC> ecList;
    @ManyToOne
    private Semestre semestre;
}
