package dk.nikolaj.webbank.repositories;

import dk.nikolaj.webbank.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
