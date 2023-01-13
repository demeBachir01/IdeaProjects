package cahier.text.gestioncahierdetexte.mappers;

import cahier.text.gestioncahierdetexte.dtos.DepartementDTO;
import cahier.text.gestioncahierdetexte.entities.Departement;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class DepartementMapper {
    public DepartementDTO fromDepartement(Departement departement){
        DepartementDTO departementDTO=new DepartementDTO();
        BeanUtils.copyProperties(departement, departementDTO);
        return  departementDTO;
    }

  public  Departement fromDepartementDTO(DepartementDTO departementDTO){
        Departement departement=new Departement();
        BeanUtils.copyProperties(departementDTO, departement);
        return  departement;
    }
}
