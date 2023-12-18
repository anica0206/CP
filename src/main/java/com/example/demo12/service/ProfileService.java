package com.example.demo12.service;

import com.example.demo12.mapper.UserMapper;
import com.example.demo12.model.Profile;
import com.example.demo12.model.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProfileService {

    @Autowired
    private UserMapper profileMapper;
    @Autowired
    private UserMapper userMapper;

    public void saveInfo(Profile profile) { userMapper.insertProfile(new Profile()); }
}
