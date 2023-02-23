package dk.nikolaj.webbank.controllers.api;

import dk.nikolaj.webbank.dto.AuthDto;
import dk.nikolaj.webbank.dto.LoginDto;
import dk.nikolaj.webbank.dto.RegisterDto;
import dk.nikolaj.webbank.model.User;
import dk.nikolaj.webbank.model.enums.Roles;
import dk.nikolaj.webbank.security.jwt.JwtAuthToken;
import dk.nikolaj.webbank.service.interfaces.RoleService;
import dk.nikolaj.webbank.service.interfaces.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth-api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthApiController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final JwtAuthToken jwtAuthToken;

    public AuthApiController(
            AuthenticationManager authenticationManager,
            UserService userService,
            RoleService roleService,
            PasswordEncoder passwordEncoder,
            JwtAuthToken jwtAuthToken
    ) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.jwtAuthToken = jwtAuthToken;
    }

    @PostMapping("login")
    public ResponseEntity<AuthDto> login(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(),
                        loginDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtAuthToken.generateToken(authentication);
        return new ResponseEntity<>(new AuthDto(token), HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        if(userService.existsByEmail(registerDto.getEmail())) {
            return new ResponseEntity<>("Email already exist", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());

        Set<Roles> userRoles = new HashSet<>();
        userRoles.add(Roles.CUSTOMER);
        user.setRoles(userRoles);

        userService.addUser(user);

        return new ResponseEntity<>("Registration successful", HttpStatus.OK);
    }
}
