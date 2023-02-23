package dk.nikolaj.webbank.service;

import dk.nikolaj.webbank.exceptions.NotFoundException;
import dk.nikolaj.webbank.model.User;
import dk.nikolaj.webbank.repositories.UserRepository;
import dk.nikolaj.webbank.service.interfaces.RoleService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final UserRepository userRepository;

    public RoleServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new NotFoundException());
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }
}
