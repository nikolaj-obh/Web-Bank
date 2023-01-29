package dk.nikolaj.webbank.repositories;

import dk.nikolaj.webbank.model.BankTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankTransactionRepository extends JpaRepository<BankTransaction, Long> {
}
