package com.example.demo12.service;

import com.example.demo12.model.Jobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobsService {
    @Autowired
    private JobsMapper jobsMapper;
    public List<Jobs> getJobsList(){return jobsMapper.getJobs(); }

}
