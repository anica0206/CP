package com.example.demo12.controller;


import com.example.demo12.mapper.courseMapper;
import com.example.demo12.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private courseMapper courseMapper;

    @RequestMapping("/Recommend/")
    public String Course (Model model) {
        List<Course> course = courseMapper.getCourse();

        model.addAttribute("course1", course);
        return "Course";//Course.jsp
    }


}
