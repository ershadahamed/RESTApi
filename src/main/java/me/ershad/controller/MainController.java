package me.ershad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    // Just wanna avoid white label error msg
    @GetMapping("/")
    public String welcomePage(){
        return "<h1>Welcome</h1>";
    }

}
