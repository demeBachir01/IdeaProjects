package cahier.text.gestioncahierdetexte.controleur;

import cahier.text.gestioncahierdetexte.entities.Affecter;
import cahier.text.gestioncahierdetexte.entities.SeanceCours;
import cahier.text.gestioncahierdetexte.repositories.AffecterRepository;
import cahier.text.gestioncahierdetexte.repositories.SeanceCoursRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/")
public class SeanceCoursControlleur {
    private SeanceCoursRepository seanceCoursRepository;
    private AffecterRepository affecterRepository;
    @GetMapping("/listeSeanceCours")
    public Collection<SeanceCours> seanceCours(){
        return seanceCoursRepository.findAll();
    }
    @GetMapping("seanceCours/{idSeance}")
    public SeanceCours seanceCours(@PathVariable Long idSeance){
        SeanceCours seanceCours=seanceCoursRepository.findById(idSeance).get();
        return seanceCours;
    }

    @PostMapping("/saveSeance/{idAffecter}")
    public SeanceCours saveSeanceCours(@PathVariable Long idAffecter, @RequestBody SeanceCours seanceCours){
        Affecter affecter=affecterRepository.findById(idAffecter).get();
        seanceCours.setAffecter(affecter);
        SeanceCours saveSeance = seanceCoursRepository.save(seanceCours);
        return  saveSeance;
    }


    @PutMapping("/updateSeance")
    public SeanceCours upDateSeanceCours(@RequestBody SeanceCours seanceCours){
        SeanceCours s=seanceCoursRepository.findById(seanceCours.getIdSeance()).get();
        if(s != null){
                s = seanceCoursRepository.save(seanceCours);
        }

       return s;
    }
    @DeleteMapping("/supprimerSeance/{idSeance}")
    public  void deleteSeance(@PathVariable Long idSeance){
        SeanceCours seanceCours = seanceCoursRepository.findById(idSeance).get();
        if( seanceCours != null) {
            seanceCoursRepository.delete(seanceCours);
        }
    }
}
