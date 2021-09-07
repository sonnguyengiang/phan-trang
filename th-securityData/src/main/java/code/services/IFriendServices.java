package code.services;

import code.model.Friend;

import java.util.ArrayList;

public interface IFriendServices {
    void save(Friend friend);

    ArrayList<Friend> findIdNon_Friend(long id_user);


    Friend findById(long id);

//    void updateFriend (long id_list);

//    void deleteFriend(long id_list);
    void delete(Friend friend);

    ArrayList<Friend> findNonFriend();
}
