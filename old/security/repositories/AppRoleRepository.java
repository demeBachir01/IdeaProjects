package cahier.text.gestioncahierdetexte.security.repositories;

import cahier.text.gestioncahierdetexte.security.entities.AppRoles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface AppRoleRepository extends JpaRepository<AppRoles,Long> {
   AppRoles findByRoleName(String roleName);
}
