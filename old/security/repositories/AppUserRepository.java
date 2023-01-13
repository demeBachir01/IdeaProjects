package cahier.text.gestioncahierdetexte.security.repositories;

import cahier.text.gestioncahierdetexte.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String > {
    AppUser findByUsername(String username);
}
