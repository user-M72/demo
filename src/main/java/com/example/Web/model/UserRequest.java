package com.example.Web.model;

import java.util.List;

public record UserRequest(
        String username,
        String password,
        List<Long> roles) {
}
