package code.repository;

import code.model.Friend;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface IFriendRepo extends CrudRepository<Friend, Long> {
//    @Query(value = "SELECT * FROM test_case.friend where account_id_account like :id_user and test_case.friend.status like 0", nativeQuery = true)
//    public ArrayList<Friend> findAllIdNon_Friend(@Param("id_user") long id_user);

    @Query(value = "select * from test_case.friend where account_id_account = :id_user and status = 1;", nativeQuery = true)
    public ArrayList<Friend> findFriend(@Param("id_user") long id_user);



    @Query(value = "select * from test_case.friend where id_friend = :id_user and status = 0;", nativeQuery = true)
    public ArrayList<Friend> findAllIdNon_Friend(@Param("id_user") long id_user);


//    @Query(value = "DELETE FROM `test_case`.`friend` WHERE (`id` = :id_list)", nativeQuery = true)
//    public void deleteFriend(@Param("id_list") long id_list);

}
