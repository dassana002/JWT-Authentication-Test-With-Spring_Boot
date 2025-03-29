package lk.ijse.cmjd109.jwtauthenticationproject.controller;

import lk.ijse.cmjd109.jwtauthenticationproject.service.JWTservice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final JWTservice jwTservice;

    @GetMapping("/userName")
    public String getUserName(@RequestParam String token) {
        return jwTservice.getUserName(token);          // Get UserName in token
    }

    @PostMapping("/login")
    public String login() {
        return jwTservice.generateJWTToken();        // Get a Token
    }
}
