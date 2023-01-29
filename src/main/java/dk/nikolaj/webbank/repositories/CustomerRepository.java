package dk.nikolaj.webbank.repositories;

import dk.nikolaj.webbank.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
