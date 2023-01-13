package cahier.text.gestioncahierdetexte.web;

import cahier.text.gestioncahierdetexte.security.Services.CompteService;
import cahier.text.gestioncahierdetexte.security.entities.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@AllArgsConstructor
public class AppUserControleur {
    private CompteService compteService;
    @GetMapping("/userss")
   public List<AppUser> listCompte(){return  compteService.listUser();}
}
