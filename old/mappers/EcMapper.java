package cahier.text.gestioncahierdetexte.mappers;

import cahier.text.gestioncahierdetexte.dtos.ECDTO;
import cahier.text.gestioncahierdetexte.entities.EC;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class EcMapper {
    public ECDTO fromEC(EC ec){
        ECDTO ecdto=new ECDTO();
        BeanUtils.copyProperties(ec, ecdto);
        return  ecdto;
    }

  public  EC fromECDTO(ECDTO ecdto){
        EC ec=new EC();
        BeanUtils.copyProperties(ecdto, ec);
        return  ec;
    }
}
