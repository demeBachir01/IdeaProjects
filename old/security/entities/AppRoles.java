package cahier.text.gestioncahierdetexte.security.entities;

import cahier.text.gestioncahierdetexte.enums.Fonction;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.Collection;
import java.util.List;

@Entity
@Data @AllArgsConstructor
public class AppRoles {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;
    private String roleName;
    @ManyToMany
    private List<AppUser> appUsers;

    public AppRoles() {
    }

    public AppRoles(String roleName) {
        this.roleName = roleName;
    }
}
