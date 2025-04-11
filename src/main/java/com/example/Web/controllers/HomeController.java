package com.example.Web.controllers;

import com.example.Web.entity.PostEntity;
import com.example.Web.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to my simple article site");
        Iterable<PostEntity> postEntities = postRepository.findAll();
        model.addAttribute("posts", postEntities);
        return "home";
    }
}