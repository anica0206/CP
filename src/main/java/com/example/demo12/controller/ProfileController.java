package com.example.demo12.controller;

import com.example.demo12.model.Course;
import com.example.demo12.model.Job;
import com.example.demo12.model.Profile;
import com.example.demo12.model.UserVO;
import com.example.demo12.service.CourseService;
import com.example.demo12.service.JobService;
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
    private JobService jobService;

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
            List<Job> jobs = jobService.getJobList(); //getAllJobs 에러나서 이걸로 고쳤는데 맞나?
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
            profile.setUserId(user_id);
            profile.setDJob(d_job);
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