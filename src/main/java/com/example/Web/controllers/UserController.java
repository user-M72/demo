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
//                .map(userEntity -> new UserDTO(userEntity.getUsername(), userEntity.addRoles()))
//                .toList();
//        model.addAttribute("userEntities", userList);
//        return "/profile";
//    }

    @GetMapping
    public String profile(Model model){
        model.addAttribute("roles", roleRepository.findAll());
        model.addAttribute("userEntities", userRepository.findAll());
        return "/profile";
    }

    @PostMapping("/saveUser")
    public String saveUser(@RequestParam String username, @RequestParam String password, @RequestParam List<Long> roles){

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
        userRepository.save(userEntity);
        return "redirect:/profile";
    }
}