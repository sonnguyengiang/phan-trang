package code.services;

import code.model.Friend;
import code.repository.IFriendRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FriendServices implements IFriendServices{

    @Autowired
    IFriendRepo iFriendRepo;

    @Override
    public void save(Friend friend) {
        iFriendRepo.save(friend);
    }

    @Override
    public ArrayList<Friend> findIdNon_Friend(long id_user) {
        return iFriendRepo.findAllIdNon_Friend(id_user);
    }


    @Override
    public Friend findById(long id) {
        return iFriendRepo.findById(id).get();
    }

    @Override
    public void delete(Friend friend) {
        iFriendRepo.delete(friend);
    }

    @Override
    public ArrayList<Friend> findNonFriend() {
        return null;
    }

//    @Override
//    public void updateFriend(long id_list) {
//        iFriendRepo.saveFriend(id_list);
//    }

//    @Override
//    public void deleteFriend(long id_list) {
//        iFriendRepo.deleteFriend(id_list);
//    }
}
