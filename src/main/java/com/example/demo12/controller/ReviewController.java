package com.example.demo12.controller;

import com.example.demo12.mapper.ReviewMapper;
import com.example.demo12.model.Board;
import com.example.demo12.model.Review;
import com.example.demo12.model.UserVO;
import com.example.demo12.service.BoardService;
import com.example.demo12.service.ReviewService;
import com.example.demo12.service.UserService;
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

    @Autowired
    ReviewMapper reviewMapper;

    @Autowired
    private UserService userService;

    @Autowired
    ReviewService reviewService;

    @RequestMapping("/review")
    public String toReviewListPage(HttpSession session, Model model) {
        String id = (String) session.getAttribute("userId");
        if (id != null) { // 로그인된 상태
            UserVO userVO = userService.getUserById(id);
            model.addAttribute("user", userVO);
            List<Review> review = reviewService.getReviewList();

            model.addAttribute("reviews",review);
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

            Review review = reviewMapper.getReviewByReviewNo(reviewNo);

            model.addAttribute("review", review);

            return "review/reviewUpdate";
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/review/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> add(@RequestBody Review review) {
        reviewMapper.insertReview(review);

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("result", "ok");

        return resultMap;
    }

    @RequestMapping(value = "/review/editDetail", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> editDetail(@RequestBody Review review) {
        reviewMapper.updateReviewByReviewId(review);

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("result", "ok");

        return resultMap;
    }

    @RequestMapping(value = "/review/delete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> delete(@RequestBody Review review) {
        reviewMapper.deleteReviewByReviewId(review);

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("result", "ok");

        return resultMap;
    }


}
