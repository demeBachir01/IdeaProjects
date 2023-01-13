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

public class ControleurEtudiant {
    SeanceCoursService seanceCoursService;
@GetMapping("/liste")
    public List<EtudiantDTO> etudiantDTOList(){
        return seanceCoursService.listEtudiant();
    }

    @GetMapping("/etudiant/{id}")
    public EtudiantDTO etudiant(@PathVariable (name = "id") Long idetudiant){return seanceCoursService.consulterEtudiant(idetudiant);}

    @PostMapping("/saveEtudiant/{idFormation}")
    public EtudiantDTO saveEtudiant(@PathVariable Long idFormation, @RequestBody EtudiantDTO etudiantDTO){
    return  seanceCoursService.saveEtudiant(etudiantDTO,idFormation);
    }
    @PutMapping("/etudiant/{idEtudiant}")
    public EtudiantDTO upDateEtudiant(@PathVariable Long idEtudiant, @RequestBody EtudiantDTO etudiantDTO){
    etudiantDTO.setIdEtudiant(idEtudiant);
        return seanceCoursService.updateEtudiant(etudiantDTO);
    }
    @DeleteMapping("/etudiant/{id}")
    public void deleteEtudiant(@PathVariable Long id){
    seanceCoursService.deleteEtudiant(id);
    }

}
