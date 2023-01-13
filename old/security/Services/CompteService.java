package cahier.text.gestioncahierdetexte.security.Services;

import cahier.text.gestioncahierdetexte.security.entities.AppRoles;
import cahier.text.gestioncahierdetexte.security.entities.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
public interface CompteService {
    AppUser adddNewUser(AppUser appUseer);
    AppRoles addNewRole(AppRoles appRoles);
    void addRoleToUser(String username,String rolename);
    AppUser loadByUserNamr(String username);
    List<AppUser> listUser();
}
