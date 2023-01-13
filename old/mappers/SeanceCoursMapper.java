package cahier.text.gestioncahierdetexte.mappers;

import cahier.text.gestioncahierdetexte.dtos.SeanceCoursDTO;
import cahier.text.gestioncahierdetexte.entities.SeanceCours;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class SeanceCoursMapper {
    public SeanceCoursDTO  fromSeanceCours(SeanceCours seanceCours){
        SeanceCoursDTO seanceCoursDTO=new SeanceCoursDTO();
        BeanUtils.copyProperties(seanceCours, seanceCoursDTO);
        return  seanceCoursDTO;
    }

  public  SeanceCours fromSeanceCoursDTO(SeanceCoursDTO seanceCoursDTO){
        SeanceCours seanceCours=new SeanceCours();
        BeanUtils.copyProperties(seanceCoursDTO, seanceCours);
        return  seanceCours;
    }
}
