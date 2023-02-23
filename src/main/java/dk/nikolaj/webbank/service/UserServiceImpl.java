package dk.nikolaj.webbank.service;

import dk.nikolaj.webbank.model.User;
import dk.nikolaj.webbank.repositories.UserRepository;
import dk.nikolaj.webbank.service.interfaces.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {

    }

    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
