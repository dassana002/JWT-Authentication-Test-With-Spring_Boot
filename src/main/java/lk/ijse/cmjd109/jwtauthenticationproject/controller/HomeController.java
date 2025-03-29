package lk.ijse.cmjd109.jwtauthenticationproject.controller;

import lk.ijse.cmjd109.jwtauthenticationproject.service.JWTservice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class HomeController {

    private final JWTservice jwTservice;


    // Get UserName in token
    @GetMapping("/username")
    public String getUserName(@RequestParam String token) {
        return jwTservice.getUserName(token);
    }

    // Get a Token
    @PostMapping("/login")
    public String login() {
        return jwTservice.generateJWTToken();
    }
}
