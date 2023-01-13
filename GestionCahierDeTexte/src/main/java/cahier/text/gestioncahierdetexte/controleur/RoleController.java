package cahier.text.gestioncahierdetexte.controleur;

import cahier.text.gestioncahierdetexte.entities.Role;
import cahier.text.gestioncahierdetexte.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/admin/role")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/get")
    public Role getById(@RequestBody(required = false) Long id) {
        Role g = roleRepository.findById(id).get();
        return g;
    }

    @PostMapping("/add")
    public Role ajouter(@RequestBody Role role) {
        Role r = new Role();

        r.setName(role.getName());
        return roleRepository.save(r);
    }

    @PutMapping("/update")
    public Role update(@RequestBody Role role) {

        Role g = roleRepository.findById(role.getId());

        g.setName(role.getName());
        return roleRepository.save(g);
    }

    //This can be also @DeleteMapping.
    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Long id) {
        Role u = roleRepository.getOne(id);
        roleRepository.delete(u);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {

        return new ResponseEntity<>(roleRepository.findAll(), HttpStatus.OK);
    }

}
