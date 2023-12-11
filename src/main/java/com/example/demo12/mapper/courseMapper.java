package com.example.demo12.mapper;

import com.example.demo12.model.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface courseMapper {
    public List<Course> getCourse();
}
