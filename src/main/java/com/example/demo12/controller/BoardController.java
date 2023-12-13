package com.example.demo12.controller;

import com.example.demo12.mapper.BoardMapper;
import com.example.demo12.model.Board;
import com.example.demo12.model.UserVO;
import com.example.demo12.service.BoardService;
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
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private UserService userService;
    @RequestMapping("/community/list")
    public String toBoardListPage(HttpSession session, Model model) {
        String id = (String) session.getAttribute("userId");
        if (id != null) { // 로그인된 상태
            UserVO userVO = userService.getUserById(id);
            model.addAttribute("user", userVO);
            List<Board> boards = boardService.getBoardList();

            model.addAttribute("posts", boards);
            return "board/boardList";
        }
        return "redirect:/login";
    }

    @RequestMapping("/community/boardNew")
    public String toAddBoardPage(HttpSession session, Model model) throws Exception {
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
    public String viewBoard(@PathVariable("boardNo") int boardNo, Model model, HttpSession session) throws Exception {
        String id = (String) session.getAttribute("userId");
        if (id != null) { // 로그인된 상태
            UserVO userVO = userService.getUserById(id);
            model.addAttribute("user", userVO);

            Board board = boardService.getBoardByBoardNo(boardNo);
            board.setReferenceNo(board.getReferenceNo()+1);
            boardService.addReferenceNo(board);

            model.addAttribute("post", board);

            return "board/boardView";
        }
        return "redirect:/login";
    }
    //update
    @RequestMapping("/community/edit/{boardNo}")
    public String toUpdateBoardPage(@PathVariable("boardNo") int boardNo, Model model, HttpSession session) throws Exception {

        String id = (String) session.getAttribute("userId");
        if (id != null) { // 로그인된 상태
            UserVO userVO = userService.getUserById(id);
            model.addAttribute("user", userVO);
            Board board = boardService.getBoardByBoardNo(boardNo);

            model.addAttribute("post", board);

            return "board/boardUpdate";
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/community/editDetail", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> updateBoard(@RequestBody Board board) {
        boardService.modifyBoard(board);

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("result", "ok");

        return resultMap;
    }

    @RequestMapping(value = "/community/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> addBoard(@RequestBody Board board) {
        boardService.addBoard(board);

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("result", "ok");

        return resultMap;
    }

    @RequestMapping(value = "/community/delete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> deleteBoard(@RequestBody Board board) {
        boardService.deleteBoard(board);

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("result", "ok");

        return resultMap;
    }


}
