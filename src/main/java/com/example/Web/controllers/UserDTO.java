package com.example.Web.controllers;

import com.example.Web.entity.ERole;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {

    public String username;

    public UserDTO(String username) {
        this.username = username;

    }
}
