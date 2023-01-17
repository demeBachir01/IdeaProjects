package cahier.text.gestioncahierdetexte.controleur;

import cahier.text.gestioncahierdetexte.entities.Departement;
import cahier.text.gestioncahierdetexte.entities.Enseignant;
import cahier.text.gestioncahierdetexte.entities.Role;
import cahier.text.gestioncahierdetexte.entities.Ufr;
import cahier.text.gestioncahierdetexte.repositories.DepartementRepository;
import cahier.text.gestioncahierdetexte.repositories.EnseignantRepository;
import cahier.text.gestioncahierdetexte.repositories.UfrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/admin/enseignant")
public class EnseignantController {

    @Autowired
    private EnseignantRepository enseignantRepository;

    @Autowired
    private DepartementRepository departementRepository;

    @Autowired
    private UfrRepository ufrRepository;

    @GetMapping("/search")
    public ArrayList<Enseignant> rechercher(@RequestParam("nom") String nom, @RequestParam("prenom") String prenom, @RequestParam("numCNI") String numCNI) {
        ArrayList<Enseignant> ens = new ArrayList<Enseignant>();
        if (enseignantRepository.findByPrenomNom(prenom, nom) != null) {
            ens = (ArrayList<Enseignant>) enseignantRepository.findByPrenomNom(prenom, nom);
        }
        return ens;
    }

    @PostMapping("/add")
    public Enseignant ajouter(@RequestBody Enseignant enseignant) {
        Enseignant ens = new Enseignant();

        ens.setNom(enseignant.getNom());
        ens.setNumCni(enseignant.getNumCni());
        ens.setPrenom(enseignant.getPrenom());
        ens.setTel(enseignant.getTel());
        ens.setCivilite(enseignant.getCivilite());
        Departement org = departementRepository.getOne(enseignant.getDepartement().getId());
        ens.setDepartement(org);
        return enseignantRepository.save(enseignant);
    }
//

    @GetMapping("findByUfr")
    public ArrayList<Enseignant> findByUfr(@RequestParam("ufr") Long u) {
        Ufr ufr = ufrRepository.findById(u).get();
        return enseignantRepository.findByUfr(ufr);
    }

    @GetMapping("findByDepartement")
    public ArrayList<Enseignant> findByDepartement(@RequestParam("departement") Long u) {
        Departement dep = departementRepository.getOne(u);
        return enseignantRepository.findByDepartement(dep);
    }

    @PostMapping("/get")
    public Enseignant getById(@RequestBody(required = false) Long id) {
        Enseignant g = enseignantRepository.findById(id).get();
        return g;
    }


    @PutMapping("/update")
    public Enseignant update(@RequestBody Enseignant enseignant) {

        Enseignant ens = enseignantRepository.getOne(enseignant.getId());

        ens.setNom(enseignant.getNom());
        ens.setNumCni(enseignant.getNumCni());
        ens.setPrenom(enseignant.getPrenom());
        ens.setTel(enseignant.getTel());
        ens.setCivilite(enseignant.getCivilite());
        Departement org = departementRepository.getOne(enseignant.getDepartement().getId());
        ens.setDepartement(org);

        return enseignantRepository.save(ens);
    }

    //This can be also @DeleteMapping.
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Long id) {
        Enseignant u = enseignantRepository.getOne(id);
        enseignantRepository.delete(u);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")

    public ArrayList<Enseignant> findAll() {

        return (ArrayList<Enseignant>) enseignantRepository.findAll();

    }

}
