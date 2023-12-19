package com.example.demo12.controller;

import com.example.demo12.model.*;
import com.example.demo12.service.CourseService;
import com.example.demo12.service.JobService;
import com.example.demo12.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProfileController {
    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private JobService jobService;


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


    @RequestMapping(value = "/profile/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> saveInfo(@RequestBody Profile profile) {
        userService.saveProfile(profile);

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("result", "ok");

        return resultMap;
    }

//    @PostMapping("/profile/add")
//    public String save(Profile profile) { // 회원가입
//        try {
//            profileService.saveInfo(profile);
//        } catch (DuplicateKeyException e) {
//            return "redirect:/register?error_code=-1";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "redirect:/register?error_code=-99";
//        }
//        return "redirect:/profile";
//    }
}