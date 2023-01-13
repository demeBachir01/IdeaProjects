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

public class ControleurFormation {
    SeanceCoursService seanceCoursService;
    //les petern pour les formation
    @PostMapping("enregistrerFormation")
    public FormationDTO saveFormation(@RequestBody FormationDTO formationDTO){
    return seanceCoursService.saveFormation(formationDTO);
    }
    @GetMapping("/listeFormation")
    public List<FormationDTO> formationDTOSList(){
        return seanceCoursService.listeFormation();
    }

    @GetMapping("/formation/{id}")
    public FormationDTO formation(@PathVariable (name = "id") Long idFormation){return seanceCoursService.consulterFormation(idFormation);}
    @PutMapping("/formation/{idFormation}")
    public FormationDTO upDateFormation(@PathVariable Long idFormation, @RequestBody FormationDTO formationDTO){
        formationDTO.setIdFormation(idFormation);
        return seanceCoursService.upDateFormation(formationDTO);
    }
    @DeleteMapping("/formation/{id}")
    public void deleteEtudiant(@PathVariable Long id){
        seanceCoursService.deleteFormation(id);
    }

}
