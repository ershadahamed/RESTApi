package me.ershad.controller;

import me.ershad.entity.User;
import me.ershad.model.Credential;
import me.ershad.model.JWTToken;
import me.ershad.service.UserService;
import me.ershad.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/new")
    public User newUser(@RequestBody User user){
        return userService.newUser(user);
    }

    @PostMapping("/authenticate")
    public JWTToken authenticate(@RequestBody Credential credential) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(credential.getUsername(), credential.getPassword())
            );
        }catch (Exception ex){
            throw new Exception("Invalid username or password");
        }

        JWTToken jwtToken = new JWTToken();
        jwtToken.setToken(jwtUtils.generateToken(credential.getUsername()));

        return jwtToken;
    }
}
