package dk.nikolaj.webbank.repositories;

import dk.nikolaj.webbank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
