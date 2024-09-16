package br.com.learn.chenrique.spring_learn_jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/open")
    public String getOpen() {
        return "OPEN";
    }

    @GetMapping("/closed")
    public String getClosed() {
        return "CLOSED";
    }

    @GetMapping("/special")
    public String getSpecial() {
        return "SPECIAL";
    }

    @GetMapping("/basic")
    public String getBasic() {
        return "BASIC";
    }
}
