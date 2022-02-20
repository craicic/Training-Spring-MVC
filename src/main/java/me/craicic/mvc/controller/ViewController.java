package me.craicic.mvc.controller;

import me.craicic.mvc.business.EntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ViewController {

    private static final Logger logger = LoggerFactory.getLogger(ViewController.class);

    private final EntryService entryService;

    @Autowired
    public ViewController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping("view/list")
    public String view(Principal principal, Model model) {
        model.addAttribute("user", principal.getName());
        model.addAttribute("entries", entryService.getUserEntries(principal.getName()).stream().toList());
        return "list";
    }

}
