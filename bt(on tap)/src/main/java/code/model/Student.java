package code.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.security.Signature;
import java.sql.Date;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Size(min = 10,max = 20,message = "min 10 max 20")
    private String name;
    @Pattern(regexp = "^0[0-9]{9}$", message = "sai dinh dang")
    private String phoneNumber;
    @Pattern(regexp = "^[\\w]{10,}$", message = "min 10")
    private String address;
    private Date date;
    @ManyToOne
    @JoinColumn(columnDefinition = "id_class")
    private ClassRoom classRoom;

    public Student(){}

    public Student( String name, String phoneNumber, String address, Date date, ClassRoom classRoom) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.date = date;
        this.classRoom = classRoom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }
}
