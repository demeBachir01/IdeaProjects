//package cahier.text.gestioncahierdetexte.web;
//
//import cahier.text.gestioncahierdetexte.dtos.ECDTO;
//import cahier.text.gestioncahierdetexte.dtos.EtudiantDTO;
//import cahier.text.gestioncahierdetexte.dtos.FormationDTO;
//import cahier.text.gestioncahierdetexte.dtos.SeanceCoursDTO;
//import cahier.text.gestioncahierdetexte.entities.Etudiant;
//import cahier.text.gestioncahierdetexte.entities.SeanceCours;
//import cahier.text.gestioncahierdetexte.service.SeanceCoursService;
//import lombok.AllArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@AllArgsConstructor
//
//public class Controleur {
//    SeanceCoursService seanceCoursService;
//@GetMapping("/liste")
//    public List<EtudiantDTO> etudiantDTOList(){
//        return seanceCoursService.listEtudiant();
//    }
//
//    @GetMapping("/etudiant/{id}")
//    public EtudiantDTO etudiant(@PathVariable (name = "id") Long idetudiant){return seanceCoursService.consulterEtudiant(idetudiant);}
//
//    @PostMapping("/saveEtudiant/{idFormation}")
//    public EtudiantDTO saveEtudiant(@PathVariable Long idFormation, @RequestBody EtudiantDTO etudiantDTO){
//    return  seanceCoursService.saveEtudiant(etudiantDTO,idFormation);
//    }
//    @PutMapping("/etudiant/{idEtudiant}")
//    public EtudiantDTO upDateEtudiant(@PathVariable Long idEtudiant, @RequestBody EtudiantDTO etudiantDTO){
//    etudiantDTO.setIdEtudiant(idEtudiant);
//        return seanceCoursService.updateEtudiant(etudiantDTO);
//    }
//    @DeleteMapping("/etudiant/{id}")
//    public void deleteEtudiant(@PathVariable Long id){
//    seanceCoursService.deleteEtudiant(id);
//    }
//
//    //les petern pour les seances cours
//
//    @GetMapping("/listeSeanceCours")
//    public  List<SeanceCoursDTO> seanceCoursDTOS(){return  seanceCoursService.listsCours();}
//
//    @GetMapping("seanceCours/{idSeance}")
//    public SeanceCoursDTO seanceCours(@PathVariable Long idSeance){return seanceCoursService.consulterSeance(idSeance);}
//
//    @PostMapping("/saveSeance/{idEc}")
//    public SeanceCoursDTO saveSeanceCours(@PathVariable String idEc, @RequestBody SeanceCoursDTO seanceCoursDTO){
//    return seanceCoursService.saveSeanceCours(seanceCoursDTO,idEc);}
//
//    @PutMapping("/updateSeance/{idSeance}")
//    public SeanceCoursDTO upDateSeanceCours(@PathVariable Long idSeance, @RequestBody SeanceCoursDTO seanceCoursDTO){
//    seanceCoursDTO.setNumSeanceCours(idSeance);
//    return seanceCoursService.upDateSeanceCours(seanceCoursDTO); }
//    @DeleteMapping("/supprimerSeance/{idSeance}")
//    public  void deleteSeance(@PathVariable Long idSeance){seanceCoursService.deleteSeanceCours(idSeance);}
//
//    //les petern pour les formation
//    @PostMapping("enregistrerFormation")
//    public FormationDTO saveFormation(@RequestBody FormationDTO formationDTO){
//    return seanceCoursService.saveFormation(formationDTO);
//    }
//    //les methodes pour EC
//    @PostMapping("/saveEC")
//    public ECDTO saveEC(@RequestBody ECDTO ecdto){
//    return  seanceCoursService.saveEC(ecdto);
//    }
//
//}
