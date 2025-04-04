package com.example.Web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfoController {

    @GetMapping("/info")
    public String info(Model model){
        model.addAttribute("message", "information about the site!!!");
        return "info";
    }
}
