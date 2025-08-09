package com.example.Web.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfoController {

    @GetMapping("/info")
    public String info(Model model,  @AuthenticationPrincipal UserDetails userDetails){
        model.addAttribute("message", "information about the site!!!");
        model.addAttribute("username", userDetails.getUsername());
        return "info";
    }
}
