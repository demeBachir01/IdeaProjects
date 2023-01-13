package cahier.text.gestioncahierdetexte.controleur;

import cahier.text.gestioncahierdetexte.entities.*;
import cahier.text.gestioncahierdetexte.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin/formation")
public class FormationController {

    @Autowired
    private FormationRepository formationRepository;

    @Autowired
    private DomaineRepository domaineRepository;

    @Autowired
    private MentionRepository mentionRepository;

    @Autowired
    private SpecialiteRepository specialiteRepository;

    @Autowired
    private AnneeScolaireRepository anneeScolaireRepository;

    @Autowired
    private NiveauRepository niveauRepository;

    @Autowired
    private DepartementRepository departementRepository;

    @Autowired
    private UfrRepository ufrRepository;

    @Autowired
    private EnseignantRepository enseignantRepository;

    @Autowired
    private ParcoursRepository parcoursRepository;

    @Autowired
    private UeRepository ueRepository;

    @Autowired
    private EcRepository ecRepository;


    @GetMapping("/search")
    public ArrayList<Formation> rechercher(@RequestParam("libelle") String libelle) {
        ArrayList<Formation> ens = new ArrayList<Formation>();
        if (formationRepository.findByLibelle(libelle) != null) {
            ens = (ArrayList<Formation>) formationRepository.findByLibelle(libelle);
        }
        return ens;
    }

    @PostMapping("/get")
    public Formation getById(@RequestBody(required = false) Long id) {
        Formation g = formationRepository.findById(id).get();
        return g;
    }

    @GetMapping("/getByAnnee")
    public ArrayList<Formation> getByAnnee(@RequestParam("anneeSco") Long idDom) {
        if (!(anneeScolaireRepository.findById(idDom).get().equals(null))) {
            return formationRepository.findByAnnee(idDom);
        }
        return null;
    }

    @GetMapping("/getByAnneeNiveau")
    public ArrayList<Formation> getByAnneeNiveau(@RequestParam("anneeSco") Long idDom, @RequestParam("niveau") Long idNiv) {
        if (!(anneeScolaireRepository.findById(idDom).get().equals(null))) {
            if (!(niveauRepository.findById(idNiv).get().equals(null))) {

                return formationRepository.findByAnneeNiveau(idDom, idNiv);
            }

        }
        return null;
    }

    @GetMapping("/getDepartements")
    public ArrayList<Departement> getDepartements(@RequestParam("form") Long idForm) {
        if (!(formationRepository.findById(idForm).get().equals(null))) {
            return departementRepository.findDepartementByFormationsId(idForm);

        }
        return null;
    }

    @GetMapping("/addDepartement")
    public Formation addDepartements(@RequestParam("form") Long idForm, @RequestParam("dept") Long idDept) {
        Formation form = formationRepository.findById(idForm).get();
        Departement d = departementRepository.findById(idDept).get();
        if (!(form.equals(null)) && !(d.equals(null))) {
            d.addFormation(form);
            departementRepository.save(d);
        }
        return form;
    }

    @GetMapping("/removeDepartement")
    public Formation removeDepartements(@RequestParam("form") Long idForm, @RequestParam("dept") Long idDept) {
        Formation form = formationRepository.findById(idForm).get();
        Departement d = departementRepository.findById(idDept).get();
        if (!(form.equals(null)) && !(d.equals(null))) {
            d.removeFormation(form.getId());
            departementRepository.save(d);
        }
        return form;
    }

    @GetMapping("/getByAnneeNiveauDept")
    public ArrayList<Formation> getByAnneeNiveauDept(@RequestParam("anneeSco") Long idDom, @RequestParam("niveau") Long idNiv, @RequestParam("dept") Long idDept) {
        if (!(departementRepository.findById(idDept).get().equals(null))) {
            ArrayList<Formation> forms = formationRepository.findFormationByDepartementsId(idDept);
            ArrayList<Formation> formReturn = new ArrayList<Formation>();
            if (!(niveauRepository.findById(idNiv).get().equals(null))) {
                if (!(anneeScolaireRepository.findById(idDom).get().equals(null))) {

                    Iterator<Formation> i = forms.iterator();
                    while (i.hasNext()) {
                        Formation f = i.next();
                        if (f.getAnneeScolaire().getId() == idDom && f.getNiveau().getId() == idNiv) {
                            formReturn.add(f);
                        }
                    }
                }
            }
            return formReturn;
        }
        return null;
    }

    @GetMapping("/getByAnneeUfr")
    public ArrayList<Formation> getByAnneeUfr(@RequestParam("anneeSco") Long idDom, @RequestParam("ufr") Long idUfr) {
        Ufr ufr = ufrRepository.findById(idUfr).get();
        AnneeScolaire an = anneeScolaireRepository.findById(idDom).get();
        if (!(ufr.equals(null))) {
            ArrayList<Formation> formReturn = new ArrayList<Formation>();
            Collection<Departement> depts = ufr.getDepartements();
            Iterator<Departement> iD = depts.iterator();
            System.out.println("parcour departement");
            while (iD.hasNext()) {
                Departement d = iD.next();
                System.out.println(d.getLibelle());
                ArrayList<Formation> forms = formationRepository.findFormationByDepartementsId(d.getId());

                if (an != null) {

                    Iterator<Formation> i = forms.iterator();
                    while (i.hasNext()) {
                        Formation f = i.next();
                        System.out.println(f.getLibelle());
                        if (f.getAnneeScolaire().getId() == idDom) {
                            Formation formExist = formReturn.stream().filter(form -> form.getId() == f.getId()).findFirst().orElse(null);
                            if (formExist == null) {
                                System.out.println("ajout d " + f.getLibelle());
                                formReturn.add(f);
                            }
                        }
                    }
                }
            }

            return formReturn;
        }
        return null;
    }

    @GetMapping("/getByAnneeNiveauUfr")
    public ArrayList<Formation> getByAnneeNiveauUfr(@RequestParam("anneeSco") Long idDom, @RequestParam("niveau") Long idNiv, @RequestParam("ufr") Long idUfr) {
        Ufr ufr = ufrRepository.findById(idUfr).get();
        if (!(ufr.equals(null))) {
            ArrayList<Formation> formReturn = new ArrayList<Formation>();
            ArrayList<Departement> depts = (ArrayList<Departement>) ufr.getDepartements();
            Iterator<Departement> iD = depts.iterator();
            while (iD.hasNext()) {
                Departement d = iD.next();
                ArrayList<Formation> forms = formationRepository.findFormationByDepartementsId(d.getId());

                if (!(niveauRepository.findById(idNiv).get().equals(null))) {
                    if (!(anneeScolaireRepository.findById(idDom).get().equals(null))) {

                        Iterator<Formation> i = forms.iterator();
                        while (i.hasNext()) {
                            Formation f = i.next();
                            if (f.getAnneeScolaire().getId() == idDom && f.getNiveau().getId() == idNiv) {
                                formReturn.add(f);
                            }
                        }
                    }
                }
            }

            return formReturn;
        }
        return null;
    }

    @GetMapping("/getByDomaine")
    public ArrayList<Formation> getByDomaine(@RequestParam("annee") Long idAn, @RequestParam("domaine") Long idDom) {
        if (!(domaineRepository.getOne(idDom)).equals(null) && !anneeScolaireRepository.findById(idAn).orElse(null).equals(null)) {
            return formationRepository.findByDomaine(idAn, idDom);
        }
        return null;
    }

    @GetMapping("/getByMention")
    public ArrayList<Formation> getByMention(@RequestParam("annee") Long idAn, @RequestParam("mention") Long idMent) {
        if (!(mentionRepository.getOne(idMent)).equals(null) && !anneeScolaireRepository.findById(idAn).orElse(null).equals(null)) {
            return formationRepository.findByMention(idAn, idMent);
        }
        return null;
    }

    @GetMapping("/getBySpecialite")
    public ArrayList<Formation> getBySpecialite(@RequestParam("annee") Long idAn, @RequestParam("specialite") Long idMent) {
        if (!(specialiteRepository.getOne(idMent)).equals(null) && !anneeScolaireRepository.findById(idAn).orElse(null).equals(null)) {
            return formationRepository.findByMention(idAn, idMent);
        }
        return null;
    }

    @GetMapping("/getByMenDomSpeci")
    public ArrayList<Formation> getByMentionDomaineSpecialite(@RequestParam("annee") Long idAn, @RequestParam("domaine") Long idDom, @RequestParam("mention") Long idMent, @RequestParam("specialite") Long spec) {
        Specialite s = specialiteRepository.findById(spec).orElse(null);
        Domaine d = domaineRepository.findById(idDom).orElse(null);
        Mention m = mentionRepository.findById(idMent).orElse(null);
        AnneeScolaire a = anneeScolaireRepository.findById(idAn).orElse(null);
        if (!(m == null) && !(d == null) && !(s == null)) {
            return formationRepository.findByMentionDomaineSpecialite(a.getId(), m.getId(), d.getId(), s.getId());
        } else if (!(m == null) && !(d == null)) {
            return formationRepository.findByMentionDomaine(a.getId(), m.getId(), d.getId());
        } else if (!(m == null)) {
            return formationRepository.findByMention(a.getId(), m.getId());
        } else if (!(d == null)) {
            return formationRepository.findByDomaine(a.getId(), d.getId());
        } else if (!(s == null)) {
            return formationRepository.findBySpecialite(a.getId(), s.getId());
        }
        return null;
    }

    @PostMapping("/add")
    public Formation ajouter(@RequestBody Formation form) {
        Formation f = new Formation();

        f.setLibelle(form.getLibelle());
        f.setCode(form.getCode());
        f.setEstValide(form.getEstValide());
        f.setDomaine(form.getDomaine());
        f.setMention(form.getMention());
        f.setNiveau(form.getNiveau());
        if (form.getSpecialite() != null) {
            f.setSpecialite(form.getSpecialite());
        }
        f.setAnneeScolaire(form.getAnneeScolaire());
        return formationRepository.save(f);
    }

    @PostMapping("/update")
    public Formation update(@RequestBody Formation form) {

        Formation f = formationRepository.findById(form.getId()).get();

        f.setLibelle(form.getLibelle());
        f.setCode(form.getCode());
        f.setEstValide(form.getEstValide());
        f.setDomaine(form.getDomaine());
        f.setMention(form.getMention());
        f.setNiveau(form.getNiveau());
        f.setAnneeScolaire(form.getAnneeScolaire());
        if (form.getSpecialite() != null) {
            f.setSpecialite(form.getSpecialite());
        }
        return formationRepository.save(f);
    }

    //This can be also @DeleteMapping.
    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Long id) {
        Formation u = formationRepository.getOne(id);
        formationRepository.delete(u);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {

        return new ResponseEntity<>(formationRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getByAnneeUfrWithChoixEns")
    public ArrayList<Formation> getByAnneeUfrWith(@RequestParam("anneeSco") Long idDom, @RequestParam("ufr") Long idUfr, @RequestParam("ens") Long idEns) {
        Ufr ufr = ufrRepository.findById(idUfr).get();
        AnneeScolaire an = anneeScolaireRepository.findById(idDom).get();
        Enseignant ens = enseignantRepository.findById(idEns).get();
        if (ufr == null) {
            return null;
        }
        if (an == null) {
            return null;
        }
        if (!(ufr.equals(null))) {
            ArrayList<Formation> formReturn = new ArrayList<Formation>();
            Collection<Departement> depts = ufr.getDepartements();
            Iterator<Departement> iD = depts.iterator();
            while (iD.hasNext()) {
                Departement d = iD.next();
                ArrayList<Formation> forms = formationRepository.findFormationByDepartementsId(d.getId());
                Iterator<Formation> i = forms.iterator();
                while (i.hasNext()) {
                    Formation f = i.next();
                    //System.out.println(f.getLibelle());
                    if (f.getAnneeScolaire().getId() == idDom) {
                        Formation formExist = formReturn.stream().filter(form -> form.getId() == f.getId()).findFirst().orElse(null);
                        if (formExist == null) {
                            ArrayList<Parcours> parcours = parcoursRepository.findByFormation(f.getId());

                            Iterator<Parcours> Iparc = parcours.iterator();
                            int indexParc = 0;
                            while (Iparc.hasNext()) {
                                Parcours parc = Iparc.next();
                                ArrayList<UE> ues = ueRepository.findByParcours(parc.getId());
                                parc.setUes(ues);
                                parcours.set(indexParc, parc);
                                System.out.println("ues " + ues.size());
                            }
                            f.setParcours(parcours);
                            System.out.println("parcours form" + f.getParcours().size());
                            System.out.println("ajout d " + f.getLibelle());

                            formReturn.add(f);
                        }
                    }
                }
            }

            return formReturn;
        }
        return null;
    }

}
