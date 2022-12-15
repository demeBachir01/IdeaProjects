package cahier.text.gestioncahierdetexte.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class SeanceCours {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSeanceCours;
    @ManyToOne
    private EC ec;
}
