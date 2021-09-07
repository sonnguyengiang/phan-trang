package code.repository;

import code.model.Account;
import code.model.Friend;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface IAccountRepo extends CrudRepository<Account, Long> {
    Account findByUsername(String username);

    Account findByUsernameContaining(String username);

    @Query(value = "SELECT id_account FROM test_case.account where test_case.account.username like concat('',:username,'')", nativeQuery = true)
    public long findIdByUsername(@Param("username") String username);

    @Query(value = "SELECT id_account FROM test_case.account where test_case.account.username like concat('',:username,'')", nativeQuery = true)
    public long findAll(@Param("username") String username);
}
