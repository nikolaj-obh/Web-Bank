package dk.nikolaj.webbank.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
@Controller
public class LoginController {
    @GetMapping({"", "/", "login", "login.html"})
    public String login() {
        return "login";
    }
}
