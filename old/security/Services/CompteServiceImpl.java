package cahier.text.gestioncahierdetexte.security.Services;

import cahier.text.gestioncahierdetexte.security.entities.AppRoles;
import cahier.text.gestioncahierdetexte.security.entities.AppUser;
import cahier.text.gestioncahierdetexte.security.repositories.AppRoleRepository;
import cahier.text.gestioncahierdetexte.security.repositories.AppUserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Data  @AllArgsConstructor
public class CompteServiceImpl implements CompteService {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;


    @Override
    public AppUser adddNewUser(AppUser appUser) {
        return appUserRepository.save(appUser) ;
    }

    @Override
    public AppRoles addNewRole(AppRoles appRoles) {

        return appRoleRepository.save(appRoles);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        AppUser appUser=appUserRepository.findByUsername(username);
        AppRoles appRoles=appRoleRepository.findByRoleName(rolename);
        appUser.getRoles().add(appRoles);

    }

    @Override
    public AppUser loadByUserNamr(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> listUser() {
        return appUserRepository.findAll();
    }
}
