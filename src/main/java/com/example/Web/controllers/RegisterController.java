package com.example.Web.controllers;

import com.example.Web.entity.RoleEntity;
import com.example.Web.entity.UserEntity;
import com.example.Web.repository.RoleRepository;
import com.example.Web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping
    public String register(Model model){
        model.addAttribute("message","Registration new user");
        model.addAttribute("roles", roleRepository.findAll());
        return "register";
    }
    @PostMapping("/saveUser")
    public String register(@RequestParam String username, @RequestParam String password, @RequestParam List<Long> roles){

        // stream api since java 8
        List<RoleEntity> roleList = roles.stream()
                .map(roleId -> roleRepository.findById(roleId))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
        var userEntity=new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(passwordEncoder.encode(password));
        userEntity.addRoles(roleList);
        var role=new RoleEntity();
        userEntity.addRole(role);
        userRepository.save(userEntity);
        return "redirect:/";
    }
}
