package dk.nikolaj.webbank.repositories;

import dk.nikolaj.webbank.model.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {
}
