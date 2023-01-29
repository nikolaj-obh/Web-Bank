package dk.nikolaj.webbank.repositories;

import dk.nikolaj.webbank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
