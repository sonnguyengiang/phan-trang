package code.repository;

import code.model.AccountRole;
import org.springframework.data.repository.CrudRepository;

public interface IAccountRoleRepo extends CrudRepository<AccountRole, Long> {
}
