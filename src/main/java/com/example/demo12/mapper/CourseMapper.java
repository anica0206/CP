package com.example.demo12.mapper;

import com.example.demo12.model.Course;
import com.example.demo12.model.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CourseMapper {
    List<Course> getCourses();
    List<Course> getCoursesByUserId(String userId);

}
