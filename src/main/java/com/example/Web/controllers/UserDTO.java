package com.example.Web.controllers;

import com.example.Web.entity.ERole;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {

    public String username;
    public ERole role;

    public UserDTO(String username, ERole role) {
        this.username = username;
        this.role = role;
    }
}
