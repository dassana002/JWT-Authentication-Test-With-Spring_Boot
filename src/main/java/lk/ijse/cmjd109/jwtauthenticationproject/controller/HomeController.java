package lk.ijse.cmjd109.jwtauthenticationproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/test")
    public String home() {
        return "Hello World";
    }

    @PostMapping("/login")
    public String login() {
        return "Hello Login";
    }
}
