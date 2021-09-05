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
        return null;
    }
}
