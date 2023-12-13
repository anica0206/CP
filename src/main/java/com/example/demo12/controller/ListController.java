package com.example.demo12.controller;

import com.example.demo12.mapper.ListMapper;
import com.example.demo12.model.Post;
import com.example.demo12.model.Review;
import com.example.demo12.model.UserVO;
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
public class ListController {
    @Autowired
    private ListMapper listMapper;

    @Autowired
    private UserService userService;
    @RequestMapping("/community/list")
    public String list(HttpSession session, Model model) {
        String id = (String) session.getAttribute("userId");
        if (id != null) { // 로그인된 상태
            UserVO userVO = userService.getUserById(id);
            model.addAttribute("user", userVO);
            List<Post> posts = listMapper.getPosts();

            model.addAttribute("posts", posts);
            return "board/board";
        }
        return "redirect:/login";
    }

    @RequestMapping("/community/boardNew")
    public String boardNewController(HttpSession session, Model model) throws Exception {
        String id = (String) session.getAttribute("userId");
        if (id != null) { // 로그인된 상태
            UserVO userVO = userService.getUserById(id);
            model.addAttribute("user", userVO);
            return "board/boardNew";
        }
        return "redirect:/login";
    }
    //경로명 community/list/boardNew 로 했었는데 안됐음.. 왜??안됐지

    //read
    @RequestMapping("/community/detail/{boardNo}")
    public String detail(@PathVariable("boardNo") int boardNo, Model model, HttpSession session) throws Exception {
        String id = (String) session.getAttribute("userId");
        if (id != null) { // 로그인된 상태
            UserVO userVO = userService.getUserById(id);
            model.addAttribute("user", userVO);
            Post post1 = new Post();
            post1.setBoardNo(boardNo);
//    @DATA 해뒀기 때문에 setboardNo가 존재하는것
            Post post = listMapper.getBoardByBoardNo(post1);

            model.addAttribute("post", post);

            return "board/boardDetail";
        }
        return "redirect:/login";
    }
    //update
    @RequestMapping("/community/edit/{boardNo}")
    public String edit(@PathVariable("boardNo") int boardNo, Model model, HttpSession session) throws Exception {

        String id = (String) session.getAttribute("userId");
        if (id != null) { // 로그인된 상태
            UserVO userVO = userService.getUserById(id);
            model.addAttribute("user", userVO);
            Post post1 = new Post();
            post1.setBoardNo(boardNo);
            Post post = listMapper.getBoardByBoardNo(post1);

            model.addAttribute("post", post);

            return "board/boardEdit";
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/community/editDetail", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> editDetail(@RequestBody Post post) {
        listMapper.updateBoardByBoardId(post);

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("result", "ok");

        return resultMap;
    }

    @RequestMapping(value = "/community/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> add(@RequestBody Post post) {
        listMapper.insertBoard(post);

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("result", "ok");

        return resultMap;
    }

    @RequestMapping(value = "/community/delete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> delete(@RequestBody Post post) {
        listMapper.deleteBoardByBoardId(post);

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("result", "ok");

        return resultMap;
    }


}
