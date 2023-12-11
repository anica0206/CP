package com.example.demo12.controller;

import com.example.demo12.mapper.ListMapper;
import com.example.demo12.model.Post;
import com.example.demo12.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ListController {
    @Autowired
    private ListMapper listMapper;

    @RequestMapping("/comunity/list")
    public String list(Model model) {
        List<Post> posts = listMapper.getPosts();

        model.addAttribute("posts", posts);
        return "board/board";
    }

    @RequestMapping("/comunity/boardNew")
    public String boardNewController() throws Exception {
        return "board/boardNew";
    }
    //경로명 comunity/list/boardNew 로 했었는데 안됐음.. 왜??안됐지

    //read
    @RequestMapping("/comunity/detail/{boardNo}")
    public String detail(@PathVariable("boardNo") int boardNo, Model model) throws Exception {
        Post post1 = new Post();
        post1.setBoardNo(boardNo);
//    @DATA 해뒀기 때문에 setboardNo가 존재하는것
        Post post = listMapper.getBoardByBoardNo(post1);

        model.addAttribute("post", post);

        return "board/boardDetail";
    }
    //update
    @RequestMapping("/comunity/edit/{boardNo}")
    public String edit(@PathVariable("boardNo") int boardNo, Model model) throws Exception {
        Post post1 = new Post();
        post1.setBoardNo(boardNo);
        Post post = listMapper.getBoardByBoardNo(post1);

        model.addAttribute("post", post);

        return "board/boardEdit";
    }

    @RequestMapping(value = "/comunity/editDetail", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> editDetail(@RequestBody Post post) {
        listMapper.updateBoardByBoardId(post);

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("result", "ok");

        return resultMap;
    }

    @RequestMapping(value = "/comunity/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> add(@RequestBody Post post) {
        listMapper.insertBoard(post);

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("result", "ok");

        return resultMap;
    }

    @RequestMapping(value = "/comunity/delete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> delete(@RequestBody Post post) {
        listMapper.deleteBoardByBoardId(post);

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("result", "ok");

        return resultMap;
    }


}
