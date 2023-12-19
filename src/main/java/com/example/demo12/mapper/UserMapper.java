package com.example.demo12.mapper;

import com.example.demo12.model.Course;
import com.example.demo12.model.Profile;
import com.example.demo12.model.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {
    void insertUser(UserVO userVO); //signUp
    UserVO getUserById(String userId);
    List<Course> getCourses();
    void insertProfile(Profile profile);

}