package com.example.demo12.controller;

import com.example.demo12.model.Board;
import com.example.demo12.model.Course;
import com.example.demo12.model.Review;
import com.example.demo12.model.UserVO;
import com.example.demo12.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String toSignupPage() {  //회원가입 페이지
        return "register";
    }

    @PostMapping("/register")
    public String signup(UserVO userVO) { // 회원가입
        try {
            userService.register(userVO);
        } catch (DuplicateKeyException e) {
            return "redirect:/register?error_code=-1";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/register?error_code=-99";
        }
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String toLoginPage(HttpSession session) { // 로그인 페이지
        Long id = (Long) session.getAttribute("userId");
        if (id != null) { // 로그인된 상태
            return "redirect:/";
        }
        return "login"; // 로그인되지 않은 상태
    }

    @PostMapping("/login")
    public String login(String userId, String password, HttpSession session) { // 로그인
        String id = userService.login(userId, password);
        if (id == null) { // 로그인 실패
            return "redirect:/login";
        }
        session.setAttribute("userId", userId);
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) { // 로그아웃
        session.invalidate();
        return "redirect:/login";
    }

    @RequestMapping("/profile")
    public String toProfilePage(HttpSession session, Model model) {
        String id = (String) session.getAttribute("userId");
        if (id != null) { // 로그인된 상태
            UserVO userVO = userService.getUserById(id);
            model.addAttribute("user", userVO);

            return "profile";
        }
        return "redirect:/login";
    }


}
