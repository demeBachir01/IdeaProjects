package cahier.text.gestioncahierdetexte.repositories;

import cahier.text.gestioncahierdetexte.entities.Etudiant;
import cahier.text.gestioncahierdetexte.entities.UE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UERepository extends JpaRepository<UE,String> {
}
