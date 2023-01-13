package cahier.text.gestioncahierdetexte.mappers;

import cahier.text.gestioncahierdetexte.dtos.EtudiantDTO;
import cahier.text.gestioncahierdetexte.entities.Etudiant;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class EtudiantMapper {
    public EtudiantDTO fromEtudiant(Etudiant etudiant){
        EtudiantDTO etudiantDTO=new EtudiantDTO();
        BeanUtils.copyProperties(etudiant, etudiantDTO);
        return  etudiantDTO;
    }

  public  Etudiant fromEtudiantDTO(EtudiantDTO etudiantDTO){
        Etudiant etudiant=new Etudiant();
        BeanUtils.copyProperties(etudiantDTO, etudiant);
        return  etudiant;
    }
}
