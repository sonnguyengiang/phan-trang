package code.repository;

import code.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface IAccountRepo extends CrudRepository<Account, Long> {
    Account findByUsername(String username);

}
