package cahier.text.gestioncahierdetexte.web;

import cahier.text.gestioncahierdetexte.dtos.ECDTO;
import cahier.text.gestioncahierdetexte.dtos.UEDTO;
import cahier.text.gestioncahierdetexte.service.SeanceCoursService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

public class ControleurUe {
    SeanceCoursService seanceCoursService;
    @GetMapping("/listUE")
    public List<UEDTO> ueDTOList(){
        return seanceCoursService.listUE();
    }

    @GetMapping("/ue/{id}")
    public UEDTO getUE(@PathVariable (name = "id") String idUE){return seanceCoursService.consulterUE(idUE);}

    @PostMapping("/saveUE")
    public UEDTO saveUE(@RequestBody UEDTO ueDTO){
    return  seanceCoursService.saveUE(ueDTO);
    }
    @PutMapping("/updateUE/{idUE}")
    public UEDTO upDateUE(@PathVariable String idUE, @RequestBody UEDTO uetDTO){
        uetDTO.setIdUE(idUE);
        return seanceCoursService.upDateUE(uetDTO);
    }
    @DeleteMapping("/uedelete/{id}")
    public void deleteUE(@PathVariable String id){
    seanceCoursService.deleteUE(id);
    }

}
