package com.example.demo12.controller;

import com.example.demo12.mapper.ReviewMapper;
import com.example.demo12.model.Board;
import com.example.demo12.model.Course;
import com.example.demo12.model.Review;
import com.example.demo12.model.UserVO;
import com.example.demo12.service.BoardService;
import com.example.demo12.service.CourseService;
import com.example.demo12.service.ReviewService;
import com.example.demo12.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ReviewController {

    final Logger LOG = LogManager.getLogger(getClass());

    @Autowired
    ReviewMapper reviewMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @Autowired
    ReviewService reviewService;

    @RequestMapping("/review")
    public String toReviewListPage(HttpSession session, Model model) {
        String id = (String) session.getAttribute("userId");
        if (id != null) { // 로그인된 상태
            UserVO userVO = userService.getUserById(id);
            model.addAttribute("user", userVO);
            List<Review> review = reviewService.getReviewList();
            List<Course> courses = courseService.getCourseHistorys(id);

            model.addAttribute("reviews",review);
            model.addAttribute("courses", courses);

            return "review/reviewList";
        }
        return "redirect:/login";
    }

    @RequestMapping("/review/new")
    public String toAddReviewPage(HttpSession session, Model model) throws Exception {

        String id = (String) session.getAttribute("userId");
        if (id != null) { // 로그인된 상태
            UserVO userVO = userService.getUserById(id);
            model.addAttribute("user", userVO);

            List<Course> courses = courseService.getCourseHistorys(id);
            model.addAttribute("courses", courses);

            return "review/reviewNew";
        }
        return "redirect:/login";
        // views/review 안의 reviewNew.jsp 파일 리턴
    }

    @RequestMapping("/review/detail/{reviewNo}")
    public String viewReview(@PathVariable("reviewNo") int reviewNo, Model model, HttpSession session) throws Exception {
        String id = (String) session.getAttribute("userId");
        if (id != null) { // 로그인된 상태
            UserVO userVO = userService.getUserById(id);
            model.addAttribute("user", userVO);

            Review review = reviewService.getReviewByReviewNo(reviewNo);
            review.setReferenceNo(review.getReferenceNo()+1);
            reviewService.addReferenceNo(review);

            model.addAttribute("review", review);

            return "review/reviewView";
        }
        return "redirect:/login";

    }

    @RequestMapping("/review/edit/{reviewNo}")
    public String toUpdateReviewPage(@PathVariable("reviewNo") int reviewNo, Model model,  HttpSession session) throws Exception {

        String id = (String) session.getAttribute("userId");
        if (id != null) { // 로그인된 상태
            UserVO userVO = userService.getUserById(id);
            model.addAttribute("user", userVO);

            Review review = reviewService.getReviewByReviewNo(reviewNo);

            model.addAttribute("review", review);

            return "review/reviewUpdate";
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/review/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> add(@RequestBody Review review) {
        reviewService.addReview(review);

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("result", "ok");

        return resultMap;
    }

    @RequestMapping(value = "/review/editDetail", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> editDetail(@RequestBody Review review) {
        reviewService.updateReview(review);

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("result", "ok");

        return resultMap;
    }

    @RequestMapping(value = "/review/delete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> delete(@RequestBody Review review) {
        reviewService.deleteReview(review);

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("result", "ok");

        return resultMap;
    }


}
