package me.craicic.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("home")
    public String home() {
        return "home";
    }

    @PostMapping("view")
    public String view() {
        return "view";
    }
}
