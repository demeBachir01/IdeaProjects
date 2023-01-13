package cahier.text.gestioncahierdetexte.repositories;

import cahier.text.gestioncahierdetexte.entities.EC;
import cahier.text.gestioncahierdetexte.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EcRepository extends JpaRepository<EC,String> {
}
