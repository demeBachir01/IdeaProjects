package cahier.text.gestioncahierdetexte.service;

import cahier.text.gestioncahierdetexte.dtos.*;
import cahier.text.gestioncahierdetexte.entities.*;
import cahier.text.gestioncahierdetexte.exception.EnseignantNotFoundException;
import cahier.text.gestioncahierdetexte.exception.EtudiantNotFoundException;
import cahier.text.gestioncahierdetexte.exception.SeanceNoEnregistrerException;
import cahier.text.gestioncahierdetexte.mappers.*;
import cahier.text.gestioncahierdetexte.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
@AllArgsConstructor

public class SeanceCoursImp  implements SeanceCoursService{
  private  SeanceCourstRepository seanceCourstRepository;
 private    EtudiantRepository etudiantRepository;
 private EtudiantMapper etudiantMapper;
 private SeanceCoursMapper seanceCoursMapper;
 private EnseignanttRepository enseignanttRepository;
private EnseignantMapper enseignantMapper;
private FormationMapper formationMapper;
private FormationRepository formationRepository;
private     EcRepository ecRepository;
private EcMapper ecMapper;
private DepartementMapper departementMapper;
private DepartementRepository departementRepository;
private UEMapper ueMapper;
private UERepository ueRepository;
private UFRRepository ufrRepository;
private UFRMapper ufrMapper;


    //methodes pour seance cours
    @Override
    public SeanceCoursDTO saveSeanceCours(SeanceCoursDTO seanceCoursDTO,String idEc) {

        SeanceCours seanceCours=seanceCoursMapper.fromSeanceCoursDTO(seanceCoursDTO);
        EC ec=ecRepository.findById(idEc).get();
                    seanceCours.setEc(ec);
        SeanceCours saveSeanceCours = seanceCourstRepository.save(seanceCours);
        return  seanceCoursMapper.fromSeanceCours(saveSeanceCours);
    }
    @Override
    public SeanceCoursDTO upDateSeanceCours(SeanceCoursDTO seanceCoursDTO){

        SeanceCours seanceCours=seanceCoursMapper.fromSeanceCoursDTO(seanceCoursDTO);
        SeanceCours saveSeanceCours = seanceCourstRepository.save(seanceCours);
        return  seanceCoursMapper.fromSeanceCours(saveSeanceCours);
    }

    @Override
    public List<SeanceCoursDTO> listsCours() {
        List<SeanceCours> seanceCoursList=seanceCourstRepository.findAll();
        List<SeanceCoursDTO>  seanceCoursDTOS=new ArrayList<>();
        for (SeanceCours seanceCours : seanceCoursList){
            SeanceCoursDTO seanceCoursDTO=seanceCoursMapper.fromSeanceCours(seanceCours);
            seanceCoursDTOS.add(seanceCoursDTO);
        }
        return seanceCoursDTOS;
    }
    @Override
    public  void deleteSeanceCours(Long idSeance){
        seanceCourstRepository.deleteById(idSeance);
    }
@Override
    public SeanceCoursDTO consulterSeance(Long idSeance){
        SeanceCours seanceCours = seanceCourstRepository.findById(idSeance).orElseThrow(() -> new SeanceNoEnregistrerException("Seance not found"));
        return seanceCoursMapper.fromSeanceCours(seanceCours);
    }
    //methodes pour les etudians
    @Override
    public List<EtudiantDTO> listEtudiant() {
        List<Etudiant> etudiantList=etudiantRepository.findAll();
        List<EtudiantDTO>  etudiantDTOList=new ArrayList<>();
        for (Etudiant etudiant : etudiantList){
            EtudiantDTO etudiantDTO=etudiantMapper.fromEtudiant(etudiant);
            etudiantDTOList.add(etudiantDTO);
        }
        return etudiantDTOList;
    }
    @Override
    public EtudiantDTO consulterEtudiant(Long idEtudiant){
        Etudiant etudiant = etudiantRepository.findById(idEtudiant).orElseThrow(() -> new EtudiantNotFoundException("Etudiant not found"));
        return etudiantMapper.fromEtudiant(etudiant);
    }
    @Override
    public EtudiantDTO saveEtudiant(EtudiantDTO etudiantDTO, Long idFormation){

        Etudiant etudiant=etudiantMapper.fromEtudiantDTO(etudiantDTO);
        Formation formation=formationRepository.findById(idFormation).get();
        etudiant.setFormation(formation);
        Etudiant saveEtudiant = etudiantRepository.save(etudiant);
        return  etudiantMapper.fromEtudiant(saveEtudiant);
    }
    @Override
    public EtudiantDTO updateEtudiant(EtudiantDTO etudiantDTO){

        Etudiant etudiant=etudiantMapper.fromEtudiantDTO(etudiantDTO);
        Etudiant saveEtudiant = etudiantRepository.save(etudiant);
        return  etudiantMapper.fromEtudiant(saveEtudiant);
    }
    @Override
    public  void deleteEtudiant(Long idEtudiant){
        etudiantRepository.deleteById(idEtudiant);
    }
    //Les methodes pour les enseignants
    @Override
    public List<EtudiantDTO> listEnseignant(){
        List<Etudiant> etudiantList=etudiantRepository.findAll();
        List<EtudiantDTO>  etudiantDTOList=new ArrayList<>();
        for (Etudiant etudiant : etudiantList){
            EtudiantDTO etudiantDTO=etudiantMapper.fromEtudiant(etudiant);
            etudiantDTOList.add(etudiantDTO);
        }
        return etudiantDTOList;
    }
    @Override
    public EnseignantDTO consulterEnseignant(Long idEnseignant){
        Enseignant enseignant = enseignanttRepository.findById(idEnseignant).orElseThrow(() -> new EnseignantNotFoundException("Enseiganant not found"));
        return enseignantMapper.fromEnseignant(enseignant);
    }
    @Override
    public EnseignantDTO saveEnseignant(EnseignantDTO enseignantDTO){

        Enseignant enseignant=enseignantMapper.fromEnseignantDTO(enseignantDTO);
        Enseignant saveEnseignant = enseignanttRepository.save(enseignant);
        return  enseignantMapper.fromEnseignant(saveEnseignant);
    }
    @Override
    public EnseignantDTO updateEnseignant(EnseignantDTO enseignantDTO){

        Enseignant enseignant=enseignantMapper.fromEnseignantDTO(enseignantDTO);
        Enseignant saveEnseignant = enseignanttRepository.save(enseignant);
        return  enseignantMapper.fromEnseignant(saveEnseignant);
    }
    @Override
    public  void deleteEnseignant(Long idEnseignant){
        etudiantRepository.deleteById(idEnseignant);
    }

    //les methodes pour formation
    @Override
    public FormationDTO saveFormation(FormationDTO formationDTO){

        Formation formation=formationMapper.fromFormationDTO(formationDTO);
        Formation saveFormation = formationRepository.save(formation);
        return  formationMapper.fromFormation(saveFormation);
    }
    @Override
    public List<FormationDTO> listeFormation(){
        List<Formation> formationList=formationRepository.findAll();
        List<FormationDTO> formationDTOS=new  ArrayList<>();
        for (Formation formation:formationList){
            FormationDTO formationDTO=formationMapper.fromFormation(formation);
            formationDTOS.add(formationDTO);
        }
        return formationDTOS;
    }
    @Override
    public FormationDTO consulterFormation(Long idFormation){
        Formation formation=formationRepository.findById(idFormation).get();
        FormationDTO formationDTO=formationMapper.fromFormation(formation);
        return formationDTO;
    }
    @Override
    public FormationDTO upDateFormation(FormationDTO formationDTO){
        Formation formation=formationMapper.fromFormationDTO(formationDTO);
        Formation saveFormation=formationRepository.save(formation);
        return formationMapper.fromFormation(saveFormation);
    }
    @Override
    public void deleteFormation(Long idFormaion){formationRepository.deleteById(idFormaion);}

    //les methodes pour ec
    @Override
    public ECDTO saveEC(ECDTO ecdto){
        EC ec=ecMapper.fromECDTO(ecdto);
        EC ecSave=ecRepository.save(ec);
        return ecMapper.fromEC(ecSave);
    }
    @Override
    public  List<ECDTO> listEc(){
        List<EC> ecs=ecRepository.findAll();
        List<ECDTO> ecdtos=new ArrayList<>();
        for (EC ec:ecs){
            ECDTO ecdto=ecMapper.fromEC(ec);
            ecdtos.add(ecdto);
        }
        return ecdtos;
    }
    @Override
    public ECDTO consulterEc(String idEc){
        EC ec=ecRepository.findById(idEc).orElseThrow();
        ECDTO ecdto=ecMapper.fromEC(ec);
        return ecdto;
    }
    @Override
    public ECDTO upDateEC(ECDTO ecdto){
        EC ec=ecMapper.fromECDTO(ecdto);
        EC saveEc=ecRepository.save(ec);
        return  ecMapper.fromEC(ec);
    }
    @Override
    public void deleteEC(String idEC){ecRepository.deleteById(idEC);}

    //LES METHODES POUR DEPARTEMENT
    @Override
    public DepartementDTO savedepartement(DepartementDTO departementDTO){
        Departement departement=departementMapper.fromDepartementDTO(departementDTO);
        Departement saveDepartement = departementRepository.save(departement);
        return departementMapper.fromDepartement(saveDepartement);
    }
    @Override
    public List<DepartementDTO> listDepartement(){
        List<Departement> departementList=departementRepository.findAll();
        List<DepartementDTO> departementDTOS=new ArrayList<>();
        for (Departement departement:departementList){
            DepartementDTO departementDTO=departementMapper.fromDepartement(departement);
            departementDTOS.add(departementDTO);
        }
        return departementDTOS;
    }
    @Override
    public DepartementDTO consulterDepartement(Long idDepartement){
        Departement departement=departementRepository.findById(idDepartement).orElseThrow();
        return departementMapper.fromDepartement(departement);
    }
    @Override
    public DepartementDTO updateDepartement(DepartementDTO departementDTO){
        Departement departement=departementMapper.fromDepartementDTO(departementDTO);
        Departement saveDepartement = departementRepository.save(departement);
        return departementMapper.fromDepartement(saveDepartement);
    }
    @Override
    public void deleteDepartement(Long idDepartement){
        departementRepository.deleteById(idDepartement);
    }

    //les methodes pour ue
    @Override
    public UEDTO saveUE(UEDTO uedto){
        UE ue=ueMapper.fromUEDTO(uedto);
        UE ueSave=ueRepository.save(ue);
        return ueMapper.fromUE(ueSave);
    }
    @Override
    public  List<UEDTO> listUE(){
        List<UE> ues=ueRepository.findAll();
        List<UEDTO> uedtos=new ArrayList<>();
        for (UE ue:ues){
            UEDTO uedto=ueMapper.fromUE(ue);
            uedtos.add(uedto);
        }
        return uedtos;
    }
    @Override
    public UEDTO consulterUE(String idUE){
        UE ue=ueRepository.findById(idUE).orElseThrow();
        UEDTO uedto=ueMapper.fromUE(ue);
        return uedto;
    }
    @Override
    public UEDTO upDateUE(UEDTO uedto){
        UE ue=ueMapper.fromUEDTO(uedto);
        UE saveUE=ueRepository.save(ue);
        return  ueMapper.fromUE(ue);
    }
    @Override
    public void deleteUE(String idUE){ueRepository.deleteById(idUE);}
//les methodes pour ufr
    @Override
    public UFRDTO saveUFR(UFRDTO ufrdto){
    UFR ufr=ufrMapper.fromUFRDTO(ufrdto);
    UFR ufrSave=ufrRepository.save(ufr);
    return ufrMapper.fromUFR(ufrSave);
}
    @Override
    public  List<UFRDTO> listUFR(){
        List<UFR> ufrs=ufrRepository.findAll();
        List<UFRDTO> ufrdtos=new ArrayList<>();
        for (UFR ufr:ufrs){
            UFRDTO ufrdto=ufrMapper.fromUFR(ufr);
            ufrdtos.add(ufrdto);
        }
        return ufrdtos;
    }
    @Override
    public UFRDTO consulterUFR(String idUFR){
        UFR ufr=ufrRepository.findById(idUFR).orElseThrow();
        UFRDTO ufrdto=ufrMapper.fromUFR(ufr);
        return ufrdto;
    }
    @Override
    public UFRDTO upDateUFR(UFRDTO ufrdto){
        UFR ufr=ufrMapper.fromUFRDTO(ufrdto);
        UFR saveUEFR=ufrRepository.save(ufr);
        return  ufrMapper.fromUFR(ufr);
    }
    @Override
    public void deleteUFR(String idUFR){ueRepository.deleteById(idUFR);}

}
