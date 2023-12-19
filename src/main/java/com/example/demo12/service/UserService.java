package com.example.demo12.service;

import com.example.demo12.mapper.UserMapper;
import com.example.demo12.model.Course;
import com.example.demo12.model.Profile;
import com.example.demo12.model.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void register(UserVO userVO) {
        userMapper.insertUser(userVO);
    }

    public UserVO getUserById(String userId) {
        return userMapper.getUserById(userId);
    }

    public String login(String id, String password) {
        UserVO userVO = userMapper.getUserById(id);
        if (userVO.getPassword().equals(password)) {
            return userVO.getUserId();
        }
        return null;
    }

    public void saveProfile(Profile profile) { userMapper.insertProfile(profile); }

}
