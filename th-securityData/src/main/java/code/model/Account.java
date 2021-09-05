package code.model;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_account;
    private String username;
    private String password;
    private String name;
    private String address;
    @ManyToOne
    private AccountRole accountRole;

    public Account(){}

    public Account(long id_account, String username, String password, String name, String address, AccountRole accountRole) {
        this.id_account = id_account;
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.accountRole = accountRole;
    }

    public long getId_account() {
        return id_account;
    }

    public void setId_account(long id_account) {
        this.id_account = id_account;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public AccountRole getAccountRole() {
        return accountRole;
    }

    public void setAccountRole(AccountRole accountRole) {
        this.accountRole = accountRole;
    }
}
