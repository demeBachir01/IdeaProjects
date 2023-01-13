package cahier.text.gestioncahierdetexte.controleur;

import cahier.text.gestioncahierdetexte.entities.AtomePedagogique;
import cahier.text.gestioncahierdetexte.repositories.AtomePedagogiqueRepository;
import cahier.text.gestioncahierdetexte.repositories.EcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin/atomeP")
public class AtomePedagogiqueController {


    AtomePedagogiqueRepository atomePedagogiqueRepository;


    @Autowired
    EcRepository ecRepository;

    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestBody AtomePedagogique a) {
        return new ResponseEntity<>(atomePedagogiqueRepository.save(a), HttpStatus.CREATED);
    }

    @PostMapping("/get")
    public AtomePedagogique getById(@RequestBody(required = false) Long id) {
        AtomePedagogique g = atomePedagogiqueRepository.findById(id).get();
        return g;
    }

    @GetMapping("/getByEc")
    public ArrayList<AtomePedagogique> getByEc(@RequestParam("ec") Long id) {
        if (id != 0) {
            //if(!(semestreRepository.findById(idP).get()).equals(null)) {
            return atomePedagogiqueRepository.findByEc(id);
        }
        return null;
    }


    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody AtomePedagogique ec) {

        return new ResponseEntity<>(atomePedagogiqueRepository.save(ec), HttpStatus.CREATED);
    }

    //This can be also @DeleteMapping.
    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody AtomePedagogique a) {
        AtomePedagogique atome = atomePedagogiqueRepository.getOne(a.getId());
        atomePedagogiqueRepository.delete(atome);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {

        return new ResponseEntity<>(atomePedagogiqueRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/number")
    public ResponseEntity<?> numberOf() {
        Long number = atomePedagogiqueRepository.count();

        return new ResponseEntity<>(number.toString(), HttpStatus.OK);
    }

}
