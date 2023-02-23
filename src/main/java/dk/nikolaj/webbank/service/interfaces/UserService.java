package dk.nikolaj.webbank.service.interfaces;

import dk.nikolaj.webbank.model.User;

import java.util.List;

public interface UserService {

    boolean existsByEmail(String email);

    List<User> listAllUsers();

    void addUser(User user);

    User getUser(Long id);

    void saveUser(User user);

    void deleteUser(Long id);
}
