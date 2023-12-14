package com.example.demo12.service;

import com.example.demo12.mapper.BoardMapper;
import com.example.demo12.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    public Board getBoardByBoardNo(int boardNo) {
        return boardMapper.getBoardByBoardNo(boardNo);
    }

    public void addReferenceNo(Board board) {
        boardMapper.updateBoardReferenceNo(board);
    }

    public List<Board> getBoardList() {
        return boardMapper.getBoards();
    }

    public void addBoard(Board board){
        boardMapper.insertBoard(board);
    }
    public void updateBoard(Board board){
        boardMapper.updateBoardByBoardId(board);
    }
    public void deleteBoard(Board board){
        boardMapper.deleteBoardByBoardId(board);
    }
}
