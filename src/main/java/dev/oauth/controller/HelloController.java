package dev.oauth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class HelloController {

    @GetMapping("/api/data")
    @PreAuthorize("hasAuthority('SCOPE_photo')")
    public String getData(JwtAuthenticationToken authToken) {
        System.out.println(authToken);


        //값을 꺼낼때
        //authToken.getPrincipal();

        return "Hello";
    }

}
