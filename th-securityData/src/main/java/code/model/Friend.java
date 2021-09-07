package code.model;

import javax.persistence.*;

@Entity
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long id_friend;
    @Column(columnDefinition = "int default 0")
    private long status;
    @ManyToOne
    private Account account;

    public Friend(){}

    public Friend(long id, long id_friend, long status, Account account) {
        this.id = id;
        this.id_friend = id_friend;
        this.status = status;
        this.account = account;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_friend() {
        return id_friend;
    }

    public void setId_friend(long id_friend) {
        this.id_friend = id_friend;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
