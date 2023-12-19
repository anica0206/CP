package com.example.demo12.model;

import lombok.Data;

@Data
public class UserVO {
    private String userId;
    private String password;
    private String email;
    private String name;
    private String birthday;
    private int role;
    private String desiredJob;
    private String education;
}
