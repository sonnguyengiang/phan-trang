package code.model;

import javax.persistence.*;

@Entity
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_D;
    private String name;


    public District() {
    }

    public District(long id_D, String name) {
        this.id_D = id_D;
        this.name = name;
    }

    public long getId_D() {
        return id_D;
    }

    public void setId_D(long id_D) {
        this.id_D = id_D;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
