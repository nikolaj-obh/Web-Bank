package dk.nikolaj.webbank.repositories;

import dk.nikolaj.webbank.model.CardTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardTransactionRepository extends JpaRepository<CardTransaction, Long> {
}
