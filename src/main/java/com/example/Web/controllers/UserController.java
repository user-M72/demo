package com.example.Web.controllers;

import com.example.Web.entity.RoleEntity;
import com.example.Web.entity.UserEntity;
import com.example.Web.repository.RoleRepository;
import com.example.Web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/profile")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    @GetMapping
    public String profile(Model model){
        model.addAttribute("roles", roleRepository.findAll());
        model.addAttribute("userEntities", userRepository.findAll());
        return "/profile";
    }

    @PostMapping("/saveUser")
//    public String saveUser(@ModelAttribute UserEntity userEntity){
    public String saveUser(@RequestParam String username, @RequestParam String password, @RequestParam List<Long> roles){

        // stream api since java 8
        List<RoleEntity> roleList = roles.stream()
                .map(roleId -> roleRepository.findById(roleId))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
        var userEntity=new UserEntity();
        userEntity.setUsername(username);
        userEntity.setUserpassword(password);
//        roleList.forEach(userEntity::addRole);
        userEntity.addRoles(roleList);
        userRepository.save(userEntity);
        return "redirect:/profile";
    }

}
