package dk.nikolaj.webbank.repositories;

import dk.nikolaj.webbank.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch,Long> {
}
