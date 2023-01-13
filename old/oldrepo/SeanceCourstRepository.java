package cahier.text.gestioncahierdetexte.repositories;

import cahier.text.gestioncahierdetexte.entities.Etudiant;
import cahier.text.gestioncahierdetexte.entities.SeanceCours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeanceCourstRepository extends JpaRepository<SeanceCours,Long> {
}
