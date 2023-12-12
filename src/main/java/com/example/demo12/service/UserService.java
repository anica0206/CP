package com.example.demo12.service;

import com.example.demo12.mapper.UserMapper;
import com.example.demo12.model.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
}
