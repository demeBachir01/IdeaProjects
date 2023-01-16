package cahier.text.gestioncahierdetexte.controleur;

import cahier.text.gestioncahierdetexte.entities.Departement;
import cahier.text.gestioncahierdetexte.entities.Ufr;
import cahier.text.gestioncahierdetexte.repositories.DepartementRepository;
import cahier.text.gestioncahierdetexte.repositories.UfrRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/admin/departement")
public class DepartementController {

    private DepartementRepository departementRepository;

    private UfrRepository ufrRepository;

    @GetMapping("/search")
    public ArrayList<Departement> rechercher(@RequestParam("libelle") String libelle) {
        ArrayList<Departement> ens = new ArrayList<Departement>();
        if (departementRepository.findByLibelle(libelle) != null) {
            ens = (ArrayList<Departement>) departementRepository.findByLibelle(libelle);
        }
        return ens;
    }

    @GetMapping("findByUfr")
    public ArrayList<Departement> findByUfr(@RequestParam("ufr") Long u) {
        Ufr ufr = ufrRepository.findById(u).get();
        return departementRepository.findByUfr(ufr);
    }

    @GetMapping("/get")
    public Departement getById(@RequestBody(required = false) Long id) {
        Departement g = departementRepository.findById(id).get();
        return g;
    }

    @PostMapping("/add")
    public Departement ajouter(@RequestBody Departement org) {

        return departementRepository.save(org);
    }

    @PutMapping("/update")
    public Departement update(@RequestBody Departement org) {

        return departementRepository.save(org);
    }

    //This can be also @DeleteMapping.
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Long id) {
        Departement u = departementRepository.getOne(id);
        departementRepository.delete(u);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {

        return new ResponseEntity<>(departementRepository.findAll(), HttpStatus.OK);
    }

}
