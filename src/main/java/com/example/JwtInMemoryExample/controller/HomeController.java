package com.example.JwtInMemoryExample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/home")
public class HomeController {

//    username: user
//    password: e5c18562-9060-4a57-a1bc-c42a8b2ea2d7 (will get this value from console, when we start the app  and if we
//    define below properties in application.properties file then this value will not come in console:
//    spring.security.user.name, spring.security.user.password OR if we are using username/password from configuration bean OR
//    from DB then also these things will not come in console)

    @GetMapping("/users")
    public String getUsers(){
        System.out.println("Getting users");
        return "Users";
    }

    @GetMapping("/current-user")
    public String getLoggedInUser(Principal principal){
        return principal.getName();
    }
}
