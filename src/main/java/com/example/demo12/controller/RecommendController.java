package com.example.demo12.controller;

import com.example.demo12.model.Academy;
import com.example.demo12.model.Course;
import com.example.demo12.model.Job;
import com.example.demo12.model.UserVO;
import com.example.demo12.service.CourseService;
import com.example.demo12.service.JobService;
import com.example.demo12.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class RecommendController {

    @Autowired
    private UserService userService;
    @Autowired
    private CourseService courseService;

    @Autowired
    private JobService jobService;

    @RequestMapping("/recommend")
    public String toRecommendPage(HttpSession session, Model model) {
        String id = (String) session.getAttribute("userId");
        if (id != null) { // 로그인된 상태
            UserVO userVO = userService.getUserById(id);
            model.addAttribute("user", userVO);
            List<Academy> areas = courseService.getAcademyAreas();
            model.addAttribute("academys", areas);
            List<Job> jobs = jobService.getJobList();
            model.addAttribute("jobs", jobs);

            return "recommend";
        }
        return "redirect:/login";
    }

//    @RequestMapping("/recommend/{area}/{job}")
//    public String getRecommends(@PathVariable("area") String area, @PathVariable("job") String job, HttpSession session, Model model) {
//        String id = (String) session.getAttribute("userId");
//        if (id != null) { // 로그인된 상태
//            UserVO userVO = userService.getUserById(id);
//            model.addAttribute("user", userVO);
//
//            List<Course> courses = courseService.getCourseRecommends(area, job);
//            model.addAttribute("courses", courses);
//
//            return "recommend";
//        }
//        return "redirect:/login";
//    }

    @RequestMapping("/recommend/getCourses")
    public String getRecommends(HttpSession session, HttpServletRequest request, Model model) {

        String id = (String) session.getAttribute("userId");
        if (id != null) {
            UserVO userVO = userService.getUserById(id);
            model.addAttribute("user", userVO);
            List<Academy> areas = courseService.getAcademyAreas();
            model.addAttribute("academys", areas);
            List<Job> jobs = jobService.getJobList();
            model.addAttribute("jobs", jobs);

            String area = request.getParameter("wantedArea");
            String jobName = request.getParameter("wantedJob");
            HashMap<String, Object> prams = new HashMap<String, Object>();
            prams.put("area", area);
            prams.put("jobName", jobName);

            System.out.println(area);
            System.out.println(jobName);

            List<Course> courses = courseService.getCourseRecommends(prams);
            model.addAttribute("courses", courses);
            System.out.println(courses);

            System.out.println(courses);
            return "recommend";
        }
        return "redirect:/login";
    }
}


