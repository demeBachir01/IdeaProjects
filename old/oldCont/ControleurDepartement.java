package cahier.text.gestioncahierdetexte.web;

import cahier.text.gestioncahierdetexte.dtos.*;
import cahier.text.gestioncahierdetexte.service.SeanceCoursService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

public class ControleurDepartement {
    SeanceCoursService seanceCoursService;
    @GetMapping("/departments")
    public List<DepartementDTO> departementDTOS(){
        return seanceCoursService.listDepartement();
    }

    @GetMapping("/departement/{id}")
    public DepartementDTO departement(@PathVariable (name = "id") Long idDepartement){return seanceCoursService.consulterDepartement(idDepartement);}

    @PostMapping("/saveDepartement/{idUfr}")
    public EtudiantDTO saveEtudiant(@PathVariable Long idFormation, @RequestBody EtudiantDTO etudiantDTO){
    return  seanceCoursService.saveEtudiant(etudiantDTO,idFormation);
    }
    @PutMapping("/departement/{idDepartement}")
    public DepartementDTO upDateDepartement(@PathVariable Long idDepartement, @RequestBody DepartementDTO departementDTO){
    departementDTO.setIdDepartement(idDepartement);
        return seanceCoursService.updateDepartement(departementDTO);
    }
    @DeleteMapping("/departement/{id}")
    public void deleteEtudiant(@PathVariable Long id){
    seanceCoursService.deleteEtudiant(id);
    }

}
