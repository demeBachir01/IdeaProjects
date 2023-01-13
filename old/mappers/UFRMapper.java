package cahier.text.gestioncahierdetexte.mappers;

import cahier.text.gestioncahierdetexte.dtos.UFRDTO;
import cahier.text.gestioncahierdetexte.entities.UFR;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UFRMapper {
    public UFRDTO fromUFR(UFR ufr){
        UFRDTO ufrdto=new UFRDTO();
        BeanUtils.copyProperties(ufr, ufrdto);
        return  ufrdto;
    }

  public  UFR fromUFRDTO(UFRDTO ufrdto){
        UFR ufr=new UFR();
        BeanUtils.copyProperties(ufrdto, ufr);
        return  ufr;
    }
}
