package cahier.text.gestioncahierdetexte;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class GestionCahierDeTexteApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionCahierDeTexteApplication.class, args);
    }
//@Bean
//    CommandLineRunner start(CompteService compteService){
//     return args -> {
//         compteService.addNewRole(new AppRoles("user"));
//         compteService.addNewRole(new AppRoles("admin"));
//         compteService.addNewRole(new AppRoles("RespForm"));
//         compteService.addNewRole(new AppRoles("ChefDep"));
//         compteService.addNewRole(new AppRoles("viceRect"));
//         compteService.adddNewUser(new AppUser("user1","1234",new ArrayList<>()));
//         compteService.adddNewUser(new AppUser("admin","1234",new ArrayList<>()));
//         compteService.adddNewUser(new AppUser("user2","1234",new ArrayList<>()));
//         compteService.adddNewUser(new AppUser("user3","1234",new ArrayList<>()));
//         compteService.adddNewUser(new AppUser("user4","1234",new ArrayList<>()));
//
//         compteService.addRoleToUser("user1","user");
//         compteService.addRoleToUser("admin","user");
//         compteService.addRoleToUser("admin","admin");
//         compteService.addRoleToUser("user2","user");
//         compteService.addRoleToUser("user2","RespForm");
//         compteService.addRoleToUser("user3","user");
//         compteService.addRoleToUser("user3","ChefDep");
//         compteService.addRoleToUser("user4","user");
//         compteService.addRoleToUser("user4","viceRect");








//     };
//    };


//   // @Bean
//    CommandLineRunner start(EtudiantRepository etudiantRepository,
//                            EnseignanttRepository enseignanttRepository,
//                            UERepository ueRepository,
//                            DepartementRepository departementRepository,
//                            EcRepository ecRepository,
//                            SeanceCourstRepository seanceCourstRepository,
//                            SemestreRepository semestreRepository,
//                            UFRRepository ufrRepository,
//                            FormationRepository formationRepository,
//                            NiveauRepository niveauRepository) {
//        return args -> {
//            //enregistrement d'un ufr
//            ufr.setNomUfr("SATIC");
//            ufr.setIdUfr("Satic");
//            ufrRepository.save(ufr);
//
//            //enregistrement d'un departement
//            departement.setUfr(ufr);
//            departement.setNomDepartement("TIC");
//            departementRepository.save(departement);
//
//            //enregistrement d'un enseignant
//
//            enseignant.setIdEnseignant(2);
//            enseignant.setFonction(Fonction.DIRECTEUR_DES_ETUDES);
//            enseignant.setNom("KA");
//            enseignant.setPrenom("Khoureyche");
//            enseignant.setProfil(Profil.PERMANENT);
//            enseignanttRepository.save(enseignant);
//
//            //enregistrement d'un etudiant
////            List<String> listEtudiant = null;
////            listEtudiant.add("Moussa");
////            listEtudiant.add("Falou");
////            listEtudiant.add("Awa");
////            listEtudiant.add("Binta");
//            //enreigistrer formation
//
//            formation.setNomFormation("D2A");
//            formation.setDomaine("RESEAU");
//            formation.setSpecialite("INTERNET");
//          formationRepository.save(formation);
//
//
//            etudiant.setPrenom("Moussa");
//            etudiant.setNom("BA");
//            etudiant.setDateDeNaissance(new Date());
//            etudiant.setFormation(formation);
//            etudiant.setLieuDeNaissance("Bambey");
//            etudiantRepository.save(etudiant);
//
//            Etudiant etdt=etudiantRepository.findById(1204L).get();
//            if(etdt !=null){
//                System.out.println(etdt.getNom()+" "+etdt.getPrenom()+" "+etdt.getFormation());            }
//
//        };
//    }

}
