package cahier.text.gestioncahierdetexte.mappers;

import cahier.text.gestioncahierdetexte.dtos.FormationDTO;
import cahier.text.gestioncahierdetexte.entities.Formation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class FormationMapper {
    public FormationDTO fromFormation(Formation formation){
        FormationDTO formationDTO=new FormationDTO();
        BeanUtils.copyProperties(formation, formationDTO);
        return  formationDTO;
    }

  public  Formation fromFormationDTO(FormationDTO formationDTO){
        Formation formation=new Formation();
        BeanUtils.copyProperties(formationDTO, formation);
        return  formation;
    }
}
