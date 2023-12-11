package com.example.demo12.model;

import lombok.Data;

import java.util.Date;

@Data
public class Post {
    private String userId;
    private String title;
    private String content;
    private Date drawup;
    private int referenceNo;
    private int boardNo;
}
