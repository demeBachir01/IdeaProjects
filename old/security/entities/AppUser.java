package cahier.text.gestioncahierdetexte.security.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Entity @AllArgsConstructor @NoArgsConstructor
public class AppUser {
    @Id
    private String username;
    private String password;
    @ManyToMany(mappedBy = "appUsers")
    private List<AppRoles> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<AppRoles> getRoles() {
        return roles;
    }

    public void setRoles(List<AppRoles> roles) {
        this.roles = roles;
    }
}
