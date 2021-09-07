package code.services;

import code.model.Account;

import java.util.ArrayList;

public interface IAccountServices {

    ArrayList<Account> findAll();

    Account findById(long id);

    Account findByUsername(String username);

    long findIdByUsername(String username);

    ArrayList<Account> findNonFriend();
}
