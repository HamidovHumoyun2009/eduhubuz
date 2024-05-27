package com.example.auth;

import lombok.Data;

@Data
public class UserDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String password;
    private UserRole role;
}
