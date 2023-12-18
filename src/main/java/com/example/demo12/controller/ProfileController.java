package com.example.demo12.controller;

import com.example.demo12.model.Course;
import com.example.demo12.model.Job;
import com.example.demo12.model.Profile;
import com.example.demo12.model.UserVO;
import com.example.demo12.service.CourseService;
import com.example.demo12.service.JobsService;
import com.example.demo12.service.ProfileService;
import com.example.demo12.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    private ProfileService profileService;

    //Profile Page view
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

    @PostMapping("/saveProfile")
    @ResponseBody
    public String saveProfile(@RequestParam String user_id,
                              @RequestParam String d_job,
                              @RequestParam String education,
                              @RequestParam String comments) {
        try {
            // MyBatis 등을 사용하여 데이터베이스에 저장하는 로직 추가
            Profile profile = new Profile();
            profile.setUser_id(user_id);
            profile.setD_job(d_job);
            profile.setEducation(education);
            profile.setComments(comments);

            profileService.saveInfo(profile);

            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}