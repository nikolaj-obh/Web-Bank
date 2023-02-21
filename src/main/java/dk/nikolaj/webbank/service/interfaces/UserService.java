package dk.nikolaj.webbank.service.interfaces;

import dk.nikolaj.webbank.model.Employee;
import dk.nikolaj.webbank.model.User;

import java.util.List;

public interface UserService {

    List<User> listAllUsers();

    User getUser(Long id);

    void saveUser(User user);

    void deleteUser(Long id);
}
