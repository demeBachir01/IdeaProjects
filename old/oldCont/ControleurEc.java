package cahier.text.gestioncahierdetexte.web;

import cahier.text.gestioncahierdetexte.dtos.ECDTO;
import cahier.text.gestioncahierdetexte.service.SeanceCoursService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

public class ControleurEc {
    SeanceCoursService seanceCoursService;
    @GetMapping("/listEc")
    public List<ECDTO> ecDTOList(){
        return seanceCoursService.listEc();
    }

    @GetMapping("/ec/{id}")
    public ECDTO getEc(@PathVariable (name = "id") String idEc){return seanceCoursService.consulterEc(idEc);}

    @PostMapping("/saveEc")
    public ECDTO saveEc(@RequestBody ECDTO ecDTO){
    return  seanceCoursService.saveEC(ecDTO);
    }
    @PutMapping("/ecupdate/{idEc}")
    public ECDTO upDateEc(@PathVariable String idEc, @RequestBody ECDTO ectDTO){
        ectDTO.setIdEC(idEc);
        return seanceCoursService.upDateEC(ectDTO);
    }
    @DeleteMapping("/ecdelete/{id}")
    public void deleteEc(@PathVariable String id){
    seanceCoursService.deleteEC(id);
    }

}
