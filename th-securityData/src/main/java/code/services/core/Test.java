package code.services.core;

import code.model.Account;
import code.model.Friend;
import code.repository.IAccountRepo;
import code.repository.IFriendRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

public class Test {

    @Autowired
    IAccountRepo iAccountRepo;

    @Autowired
    IFriendRepo iFriendRepo;

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

//    Account account = iAccountRepo.findByUsername(getPrincipal());
//
//    public ArrayList<Account> listAccount = (ArrayList<Account>) iAccountRepo.findAll();
//
//    public ArrayList<Friend> list = (ArrayList<Friend>) iFriendRepo.findFriend(account.getId_account());
//
//    public ArrayList<Account> getNonFriend() {
//        ArrayList<Account> listNonFriend = new ArrayList<>();
//        for (int i = 0; i < listAccount.size(); i++) {
//            if (listAccount.get(i).getId_account() == account.getId_account()) {
//                continue;
//            }
//
////            if (listAccount.get(i).getId_account() == )
//
//        }
//    }

}
