package com.example.demo12.mapper;

import com.example.demo12.model.Course;
import com.example.demo12.model.Jobs;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface JobsMapper {
    List<Jobs> getCourses();

}
