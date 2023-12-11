package com.example.demo12.model;

import lombok.Data;

import java.util.Date;

@Data
public class Review {
    private String userId;
    private String title;
    private int courseNo;
    private int reviewNo;
    private Date drawup;
    private int referenceNo;
    private int recommend;
    private String content;
}
