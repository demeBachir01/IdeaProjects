package cahier.text.gestioncahierdetexte.repositories;

import cahier.text.gestioncahierdetexte.entities.Enseignant;
import cahier.text.gestioncahierdetexte.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignanttRepository extends JpaRepository<Enseignant,Long> {
}