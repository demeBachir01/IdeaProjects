package cahier.text.gestioncahierdetexte.web;

import cahier.text.gestioncahierdetexte.dtos.UFRDTO;
import cahier.text.gestioncahierdetexte.service.SeanceCoursService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

public class ControleurUFR {
    SeanceCoursService seanceCoursService;
    @GetMapping("/listUFR")
    public List<UFRDTO> ufrDTOList(){
        return seanceCoursService.listUFR();
    }

    @GetMapping("/ufr/{id}")
    public UFRDTO getUFR(@PathVariable (name = "id") String idUFR){return seanceCoursService.consulterUFR(idUFR);}

    @PostMapping("/saveUFR")
    public UFRDTO saveUFR(@RequestBody UFRDTO ufrDTO){
    return  seanceCoursService.saveUFR(ufrDTO);
    }
    @PutMapping("/ufrUpdate/{idUFR}")
    public UFRDTO upDateUFR(@PathVariable String idUFR, @RequestBody UFRDTO ufrdto){
        ufrdto.setIdUfr(idUFR);
        return seanceCoursService.upDateUFR(ufrdto);
    }

    @DeleteMapping("/ufrDelete/{id}")
    public void deleteUFR(@PathVariable String id){
    seanceCoursService.deleteUFR(id);
    }

}
