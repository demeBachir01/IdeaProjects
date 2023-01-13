package cahier.text.gestioncahierdetexte.dtos;

import cahier.text.gestioncahierdetexte.entities.Departement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data


public class UFRDTO {
    private String idUfr;
    private String nomUfr;

}
