package com.example.demo12.service;

import com.example.demo12.model.Jobs;
import com.example.demo12.model.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobsService {
    @Autowired
    private JobsMapper jobsMapper;

    public Jobs getJobs(String j_name) {
        return jobsMapper.getJobs(j_name);
    }
}
