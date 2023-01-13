package cahier.text.gestioncahierdetexte.web;

import cahier.text.gestioncahierdetexte.dtos.ECDTO;
import cahier.text.gestioncahierdetexte.dtos.EtudiantDTO;
import cahier.text.gestioncahierdetexte.dtos.FormationDTO;
import cahier.text.gestioncahierdetexte.dtos.SeanceCoursDTO;
import cahier.text.gestioncahierdetexte.service.SeanceCoursService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

public class ControleurSeanceCours {
    SeanceCoursService seanceCoursService;
    //les petern pour les seances cours

    @GetMapping("/listeSeanceCours")
    public  List<SeanceCoursDTO> seanceCoursDTOS(){return  seanceCoursService.listsCours();}

    @GetMapping("seanceCours/{idSeance}")
    public SeanceCoursDTO seanceCours(@PathVariable Long idSeance){return seanceCoursService.consulterSeance(idSeance);}

    @PostMapping("/saveSeance/{idEc}")
    public SeanceCoursDTO saveSeanceCours(@PathVariable String idEc, @RequestBody SeanceCoursDTO seanceCoursDTO){
    return seanceCoursService.saveSeanceCours(seanceCoursDTO,idEc);}

    @PutMapping("/updateSeance/{idSeance}")
    public SeanceCoursDTO upDateSeanceCours(@PathVariable Long idSeance, @RequestBody SeanceCoursDTO seanceCoursDTO){
    seanceCoursDTO.setNumSeanceCours(idSeance);
    return seanceCoursService.upDateSeanceCours(seanceCoursDTO); }
    @DeleteMapping("/supprimerSeance/{idSeance}")
    public  void deleteSeance(@PathVariable Long idSeance){seanceCoursService.deleteSeanceCours(idSeance);}

}
