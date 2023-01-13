package cahier.text.gestioncahierdetexte.mappers;

import cahier.text.gestioncahierdetexte.dtos.ECDTO;
import cahier.text.gestioncahierdetexte.dtos.UEDTO;
import cahier.text.gestioncahierdetexte.entities.EC;
import cahier.text.gestioncahierdetexte.entities.UE;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UEMapper {
    public UEDTO fromUE(UE ue){
        UEDTO uedto=new UEDTO();
        BeanUtils.copyProperties(ue, uedto);
        return  uedto;
    }

  public  UE fromUEDTO(UEDTO uedto){
        UE ue=new UE();
        BeanUtils.copyProperties(uedto, ue);
        return  ue;
    }
}
