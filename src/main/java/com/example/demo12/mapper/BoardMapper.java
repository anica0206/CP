package com.example.demo12.mapper;

import com.example.demo12.model.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BoardMapper {
    List<Board> getBoards();
    void insertBoard(Board board);
    Board getBoardByBoardNo(int board);
    void updateBoardByBoardId(Board board);
    void deleteBoardByBoardId(Board board);
    void updateBoardReferenceNo(Board board);

}
