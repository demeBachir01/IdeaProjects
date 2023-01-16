package cahier.text.gestioncahierdetexte.controleur;

import cahier.text.gestioncahierdetexte.entities.*;
import cahier.text.gestioncahierdetexte.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin/directeurUfr")
public class DirecteurUfrController {

    @Autowired
    private DirecteurUfrRepository directeurUfrRepository;
    @Autowired
    private EnseignantRepository enseignantRepository;
    @Autowired
    private UfrRepository ufrRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private IndividuCompteRepository individuCompteRepository;

    @GetMapping("/get")
    public DirecteurUfr getById(@RequestBody(required = false) Long id) {
        DirecteurUfr g = directeurUfrRepository.findById(id).get();
        return g;
    }

    @GetMapping("/findByEns")
    public ArrayList<DirecteurUfr> getByEnseignant(@RequestBody(required = false) Enseignant ens) {
        Enseignant e = enseignantRepository.findById(ens.getId()).orElse(null);
        ArrayList<DirecteurUfr> g = directeurUfrRepository.findByEnseignant(e);
        return g;
    }

    @GetMapping("/findByUfr")
    public ArrayList<DirecteurUfr> getByUfr(@RequestParam("ufr") Long u) {
        //Ufr ufr = ufrRepository.findById(u).get();
        ArrayList<DirecteurUfr> dirUfr = directeurUfrRepository.findByUfr(u);//new ArrayList<DirecteurUfr>();
        DirecteurUfr d = new DirecteurUfr();
        //d.getEnseignant()
        return dirUfr;
    }

    @GetMapping("/findActifByEns")
    public DirecteurUfr getActifByEnseignant(@RequestBody(required = false) Enseignant ens) {
        Enseignant e = enseignantRepository.findById(ens.getId()).orElse(null);
        DirecteurUfr g = directeurUfrRepository.findActifByEnseignant(e);
        return g;
    }

    @GetMapping("/findActifByUf")
    public DirecteurUfr getActifByUfr(@RequestBody(required = false) Ufr g) {
        Ufr ufr = ufrRepository.findById(g.getId()).get();
        DirecteurUfr dir = directeurUfrRepository.findActifByUfr(ufr);
        return dir;
    }

    @PostMapping("/add")
    public DirecteurUfr ajouter(@RequestBody DirecteurUfr dirUfr) {
        //desactivier les autres liaisons
        ArrayList<DirecteurUfr> list = directeurUfrRepository.findByUfr(dirUfr.getUfr().getId());
        Iterator<DirecteurUfr> it = list.iterator();
        while (it.hasNext()) {
            DirecteurUfr g = it.next();
            g.setEnCours(0);
            if (g.getDateFin() != null) {

                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                Date date = new Date();
                try {
                    date = df.parse(date.toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                g.setDateFin(date);
            }
            directeurUfrRepository.save(g);
        }
        //ajouter la nouvelle liaison
        DirecteurUfr g = new DirecteurUfr();
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        //Date newDate = LocalDateTime.parse(gradeEns.getDateDebut(), formatter);

        g.setUfr(dirUfr.getUfr());
        g.setDateDebut(dirUfr.getDateDebut());
        g.setDateFin(dirUfr.getDateFin());
        g.setEnCours(1);
        Enseignant ens = dirUfr.getEnseignant();
        g.setEnseignant(ens);
        Role dirRole = roleRepository.findByName(ERole.ROLE_DIRECTEUR_UFR)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));

        ArrayList<IndividuCompte> comptes = individuCompteRepository.findByIndividu(dirUfr.getEnseignant().getId());

        System.out.println("compte individu " + comptes.size());
        if (comptes != null) {
            Iterator<IndividuCompte> compteIterator = comptes.iterator();
            while (compteIterator.hasNext()) {
                IndividuCompte compte = compteIterator.next();

                if (!compte.getRoles().contains(dirRole)) {
                    Set<Role> roles = compte.getRoles();
                    roles.add(dirRole);
                    compte.setRoles(roles);
                    individuCompteRepository.save(compte);
                }

            }
        }

        return directeurUfrRepository.save(g);
    }


    @PutMapping("/update")
    public DirecteurUfr update(@RequestBody DirecteurUfr dir) {

        DirecteurUfr g = directeurUfrRepository.getOne(dir.getId());

        g.setUfr(dir.getUfr());
        g.setDateDebut(dir.getDateDebut());
        g.setDateFin(dir.getDateFin());
        g.setEnCours(dir.getEnCours());
        g.setEnseignant(dir.getEnseignant());

        Role dirRole = roleRepository.findByName(ERole.ROLE_DIRECTEUR_UFR)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));

        ArrayList<IndividuCompte> comptes = individuCompteRepository.findByIndividu(dir.getEnseignant().getId());//(ArrayList<IndividuCompte>) dir.getEnseignant().getComptesIndividu();

        if (comptes != null) {
            Iterator<IndividuCompte> compteIterator = comptes.iterator();
            while (compteIterator.hasNext()) {
                IndividuCompte compte = compteIterator.next();

                if (!compte.getRoles().contains(dirRole)) {
                    Set<Role> roles = compte.getRoles();
                    roles.add(dirRole);
                    compte.setRoles(roles);
                    individuCompteRepository.save(compte);
                }

            }
        }

        return directeurUfrRepository.save(g);
    }

    //This can be also @DeleteMapping.
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Long id) {
        DirecteurUfr u = directeurUfrRepository.getOne(id);
        directeurUfrRepository.delete(u);
        ;
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {

        return new ResponseEntity<>(directeurUfrRepository.findAll(), HttpStatus.OK);
    }

}
