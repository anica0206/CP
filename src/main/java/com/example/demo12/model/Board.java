package com.example.demo12.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Board {
    private String userId;
    private String title;
    private String content;
    private String drawup;
    private int referenceNo;
    private int boardNo;
    private int rowNum;
}
