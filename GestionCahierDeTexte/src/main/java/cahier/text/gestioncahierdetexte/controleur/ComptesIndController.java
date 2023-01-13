package cahier.text.gestioncahierdetexte.controleur;

import cahier.text.gestioncahierdetexte.entities.Individu;
import cahier.text.gestioncahierdetexte.entities.IndividuCompte;
import cahier.text.gestioncahierdetexte.entities.Role;
import cahier.text.gestioncahierdetexte.repositories.IndividuCompteRepository;
import cahier.text.gestioncahierdetexte.repositories.IndividuRepository;
import cahier.text.gestioncahierdetexte.repositories.RoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")

public class ComptesIndController {

    IndividuCompteRepository indCompteRepo;

    RoleRepository roleRepo;


    IndividuRepository indRepo;

    PasswordEncoder encoder;

    @GetMapping("/CompteIndividus")
    public ArrayList<IndividuCompte> lesComptes() {

        return (ArrayList<IndividuCompte>) indCompteRepo.findAll();
    }

    @PostMapping("/CompteIndividus/get")
    public IndividuCompte getById(@RequestBody(required = false) Long id) {
        IndividuCompte g = indCompteRepo.findById(id).get();
        return g;
    }

    @PostMapping("/CompteIndividus/getByIndividu")
    public ArrayList<IndividuCompte> getByEnseignant(@RequestBody(required = false) Long id) {
        Individu i = indRepo.findById(id).orElse(null);
        ArrayList<IndividuCompte> g = indCompteRepo.findByIndividu(i.getId());
        return g;
    }

    @PostMapping("/CompteIndividus/add")
    public IndividuCompte ajouter(@RequestBody IndividuCompte indCompte) {

        IndividuCompte ind = new IndividuCompte();
        ind.setActif(indCompte.isActif());
        ind.setDateDebutValite(indCompte.getDateDebutValite());
        ind.setEmail(indCompte.getEmail());
        ind.setIndividu(indCompte.getIndividu());
        ind.setPasswordTemp(indCompte.getPasswordTemp());
        //System.out.println("##################"+ind.getPasswordTemp());
        ind.setPassword(encoder.encode(indCompte.getPasswordTemp()));
        Set<Role> roles = new HashSet<>();
        Iterator<Role> it = indCompte.getRoles().iterator();
        while (it.hasNext()) {
            Role r = it.next();
            Role existRole = roleRepo.findById(r.getId());
            if (existRole.getId() != null) {
                roles.add(existRole);
            }
            /*if(r.getName().name().equals(ERole.ROLE_ADMIN)) {
				  Role adminRole = roleRepo.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);
			  }else if(r.getName().name().equals(ERole.ROLE_ENSEIGNANT)) {
				  Role ensRole = roleRepo.findByName(ERole.ROLE_ENSEIGNANT)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(ensRole);
			  }else if(r.getName().name().equals(ERole.ROLE_CHEF_DEPARTEMENT)) {
				  Role chefRole = roleRepo.findByName(ERole.ROLE_CHEF_DEPARTEMENT)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(chefRole);
			  }else if(r.getName().name().equals(ERole.ROLE_VICE_RECTEUR)) {
				  Role viceRecRole = roleRepo.findByName(ERole.ROLE_VICE_RECTEUR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(viceRecRole);
			  }*/
        }

        ind.setRoles(roles);
        ind.setUsername(indCompte.getUsername());

        return indCompteRepo.save(ind);
    }

    @PostMapping("/CompteIndividus/update")
    public IndividuCompte modifier(@RequestBody IndividuCompte indCompte) {

        IndividuCompte ind = indCompteRepo.getOne(indCompte.getId());
        ind.setActif(indCompte.isActif());
        ind.setDateDebutValite(indCompte.getDateDebutValite());
        ind.setDateFinValite(indCompte.getDateFinValite());
        ind.setEmail(indCompte.getEmail());
        ind.setIndividu(indCompte.getIndividu());
        ind.setPasswordTemp(indCompte.getPasswordTemp());
        ind.setPassword(encoder.encode(indCompte.getPasswordTemp()));
        Set<Role> roles = new HashSet<>();
        Iterator<Role> it = indCompte.getRoles().iterator();
        while (it.hasNext()) {
            Role r = it.next();
            Role existRole = roleRepo.findById(r.getId());
            if (existRole.getId() != null) {
                roles.add(existRole);
            }
        }
        ind.setRoles(indCompte.getRoles());
        ind.setUsername(indCompte.getUsername());

        return indCompteRepo.save(ind);
    }

    @GetMapping("/getByusername")
    public IndividuCompte rechercher(@RequestParam("username") String username) {
        IndividuCompte ind = new IndividuCompte();
        if (indCompteRepo.findByUsername(username) != null) {
            ind = indCompteRepo.findByUsername(username).orElse(null);
        }
        return ind;
    }
}
