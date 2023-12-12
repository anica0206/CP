package com.example.demo12.mapper;

import com.example.demo12.model.UserVO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
    void insertUser(UserVO userVO); //signUp
    UserVO getUserById(String userId);
}
