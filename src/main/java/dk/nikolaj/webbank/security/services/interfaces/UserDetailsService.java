package dk.nikolaj.webbank.security.services.interfaces;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;

public interface UserDetailsService {
    @Transactional
    UserDetails loadUserByEmail(String email) throws UsernameNotFoundException;
}
