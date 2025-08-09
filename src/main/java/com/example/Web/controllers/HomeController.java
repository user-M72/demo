package com.example.Web.controllers;

import com.example.Web.entity.PostEntity;
import com.example.Web.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        Iterable<PostEntity> postEntities = postRepository.findAll();
        model.addAttribute("posts", postEntities);
        model.addAttribute("username", userDetails.getUsername());
        return "home";
    }
}