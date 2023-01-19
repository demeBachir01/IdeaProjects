package cahier.text.gestioncahierdetexte.controleur;

import cahier.text.gestioncahierdetexte.entities.Affecter;
import cahier.text.gestioncahierdetexte.entities.Enseignant;
import cahier.text.gestioncahierdetexte.repositories.AffecterRepository;
import cahier.text.gestioncahierdetexte.repositories.EnseignantRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin/affecter")
@AllArgsConstructor @NoArgsConstructor
public class AffecterControleur {
    private AffecterRepository affecterRepository;
    private EnseignantRepository enseignantRepository;

    @GetMapping("get")
    public Affecter get(@RequestParam Long id){
        Affecter affecter=affecterRepository.findById(id).get();
        return affecter;
    }
    @GetMapping("findByEnseignant")
    public Affecter getByEnseignant(@RequestBody Enseignant enseignant){
        Enseignant ens=enseignantRepository.findById(enseignant.getId()).get();
        Affecter affecter=affecterRepository.findByEnseignants(ens);
        return affecter;
    }
    @PostMapping("add")
    public  Affecter ajouter(@RequestBody Affecter affecter){
        Affecter saved = affecterRepository.save(affecter);
        return saved;
    }

    @PutMapping("update")
    public Affecter update(@RequestBody Affecter affecter){
        Affecter save = affecterRepository.save(affecter);
        return  save;
    }

    @DeleteMapping("delete")
    public void deleteAffectation(@RequestBody Affecter affecter){
        affecterRepository.deleteById(affecter.getId());
    }

    @GetMapping("getall")
    public ResponseEntity<?> listAffectation(){
        return new ResponseEntity<>(affecterRepository.findAll(), HttpStatus.OK);
    }
}
