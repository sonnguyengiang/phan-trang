package code.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
public class AccountRole implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_role;
    private String role;


    public AccountRole(){}

    public AccountRole(long id_role, String role) {
        this.id_role = id_role;
        this.role = role;
    }

    public long getId_role() {
        return id_role;
    }

    public void setId_role(long id_role) {
        this.id_role = id_role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }
}
