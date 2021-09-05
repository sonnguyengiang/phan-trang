package code.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_class;
    private String nameClass;

    public ClassRoom(){}

    public ClassRoom(long id_class, String nameClass) {
        this.id_class = id_class;
        this.nameClass = nameClass;
    }

    public long getId_class() {
        return id_class;
    }

    public void setId_class(long id_class) {
        this.id_class = id_class;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
}
