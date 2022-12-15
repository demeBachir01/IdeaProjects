package cahier.text.gestioncahierdetexte.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UE {
    @Id
    private String idUE;
    private String nomUE;
    @OneToMany (mappedBy = "ue" )
    private List<EC> ecList;
    @ManyToOne
    private Semestre semestre;
}
