package cahier.text.gestioncahierdetexte.repositories;

import cahier.text.gestioncahierdetexte.entities.Affecter;
import cahier.text.gestioncahierdetexte.entities.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AffecterRepository extends JpaRepository<Affecter,Long> {

    public Affecter findByEnseignants(Enseignant enseignant);
}
