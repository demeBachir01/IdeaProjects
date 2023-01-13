package cahier.text.gestioncahierdetexte.entities;

import cahier.text.gestioncahierdetexte.enums.Fonction;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Entity
public class IndividuCompte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private Boolean actif;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dateDebValide;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dateFinValide;
    @ManyToMany
    private Collection<Roles> roles;
    @ManyToOne
    private Personne personne;
}
