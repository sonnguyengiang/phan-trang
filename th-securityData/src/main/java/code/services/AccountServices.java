package code.services;

import code.model.Account;
import code.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AccountServices implements IAccountServices{
    @Autowired
    IAccountRepo iAccountRepo;



    @Override
    public ArrayList<Account> findAll() {
        return (ArrayList<Account>) iAccountRepo.findAll();
    }

    @Override
    public Account findById(long id) {
        return iAccountRepo.findById(id).get();
    }

    @Override
    public Account findByUsername(String username) {
        return iAccountRepo.findByUsernameContaining(username);
    }

    @Override
    public long findIdByUsername(String username) {
        return iAccountRepo.findIdByUsername(username);
    }

    @Override
    public ArrayList<Account> findNonFriend() {
        return null;
    }
}
