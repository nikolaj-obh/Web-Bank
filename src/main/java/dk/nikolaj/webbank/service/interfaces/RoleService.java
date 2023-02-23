package dk.nikolaj.webbank.service.interfaces;

import dk.nikolaj.webbank.model.User;

import java.util.List;

public interface RoleService {

    List<User> getUsers();

    User addUser(User user);

    User findUserById(Long id);

    void deleteUserById(Long id);

    User updateUser(User user);
}
