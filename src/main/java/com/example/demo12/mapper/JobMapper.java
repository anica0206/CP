package com.example.demo12.mapper;

import com.example.demo12.model.Job;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface JobMapper {
    List<Job> getJobs();

}
