package com.example.Web.controllers;

import com.example.Web.repository.RoleRepository;
import com.example.Web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

//    @GetMapping
//    public String profile(Model model) {
//        List<UserDTO> userList = userRepository.findAll().stream()
//                .map(userEntity -> new UserDTO(userEntity.getUsername()))
//                .toList();
//        model.addAttribute("userEntities", userList);
//        return "/profile";
//    }

    @GetMapping
    public String profile(Model model,  @AuthenticationPrincipal UserDetails userDetails){
        model.addAttribute("roles", roleRepository.findAll());
        model.addAttribute("userEntities", userRepository.findAll());
        model.addAttribute("username", userDetails.getUsername());
        return "/profile";
    }
}