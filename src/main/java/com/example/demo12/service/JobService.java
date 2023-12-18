package com.example.demo12.service;

import com.example.demo12.mapper.JobsMapper;
import com.example.demo12.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class JobService {

    @Autowired
    private JobsMapper jobMapper;

    public List<Job> getJobList() { return jobMapper.getJobs(); }

}