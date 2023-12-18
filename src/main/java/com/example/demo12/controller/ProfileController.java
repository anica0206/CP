package com.example.demo12.controller;

import com.example.demo12.model.Course;
import com.example.demo12.model.Job;
import com.example.demo12.model.UserVO;
import com.example.demo12.service.CourseService;
import com.example.demo12.service.JobsService;
import com.example.demo12.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProfileController {
    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private JobsService jobsService;

    @RequestMapping("/profile")
    public String toProfilePage(HttpSession session, Model model) {
        String id = (String) session.getAttribute("userId");
        if (id != null) { // 로그인된 상태
            UserVO userVO = userService.getUserById(id);
            model.addAttribute("user", userVO);
            List<Course> courses = courseService.getCourseList();
            model.addAttribute("courses", courses);
            List<Job> jobs = jobsService.getAllJobs();
            model.addAttribute("jobs", jobs);

            return "profile";
        }
        return "redirect:/login";
    }

}