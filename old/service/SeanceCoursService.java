package cahier.text.gestioncahierdetexte.service;

import cahier.text.gestioncahierdetexte.dtos.*;
import java.util.List;

public interface SeanceCoursService {


    SeanceCoursDTO saveSeanceCours(SeanceCoursDTO seanceCoursDTO,String idEc);


    SeanceCoursDTO upDateSeanceCours(SeanceCoursDTO seanceCoursDTO);


    List<SeanceCoursDTO> listsCours();

    void deleteSeanceCours(Long idSeance);

    SeanceCoursDTO consulterSeance(Long idSeance);

    List<EtudiantDTO> listEtudiant();

    EtudiantDTO consulterEtudiant(Long idEtudiant);

    //Les methodes pour les enseignants
    List<EtudiantDTO> listEnseignant();

    EnseignantDTO consulterEnseignant(Long idEtudiant);

    EtudiantDTO saveEtudiant(EtudiantDTO etudiantDTO, Long idFormation);

    EtudiantDTO updateEtudiant(EtudiantDTO etudiantDTO);

    void deleteEtudiant(Long idEtudiant);

    EnseignantDTO saveEnseignant(EnseignantDTO enseignantDTO);

    EnseignantDTO updateEnseignant(EnseignantDTO enseignantDTO);

    void deleteEnseignant(Long idEnseignant);

    //les methodes pour formation
    FormationDTO saveFormation(FormationDTO formationDTO);

    List<FormationDTO> listeFormation();

    FormationDTO consulterFormation(Long idFormation);

    FormationDTO upDateFormation(FormationDTO formationDTO);

    void deleteFormation(Long idFormaion);

    //les methodes pour ec
    ECDTO saveEC(ECDTO ecdto);

    //les methodes pour ue
    UEDTO saveUE(UEDTO uedto);

    List<ECDTO> listEc();

    //les methodes pour ufr
    UFRDTO saveUFR(UFRDTO ufrdto);

    List<UEDTO> listUE();

    ECDTO consulterEc(String idEc);

    List<UFRDTO> listUFR();

    UEDTO consulterUE(String idUE);

    ECDTO upDateEC(ECDTO ecdto);

    UFRDTO consulterUFR(String idUFR);

    UEDTO upDateUE(UEDTO uedto);

    void deleteEC(String idEC);

    //LES METHODES POUR DEPARTEMENT
    DepartementDTO savedepartement(DepartementDTO departementDTO);

    List<DepartementDTO> listDepartement();

    DepartementDTO consulterDepartement(Long idDepartement);

    DepartementDTO updateDepartement(DepartementDTO departementDTO);

    void deleteDepartement(Long idDepartement);

    UFRDTO upDateUFR(UFRDTO ufrdto);

    void deleteUE(String idUE);

    void deleteUFR(String idUFR);
}
