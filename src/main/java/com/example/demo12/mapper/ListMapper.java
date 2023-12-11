package com.example.demo12.mapper;

import com.example.demo12.model.Post;
import com.example.demo12.model.Review;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ListMapper {
    public List<Post> getPosts();
    void insertBoard(Post post);
    Post getBoardByBoardNo(Post post);
    void updateBoardByBoardId(Post post);
    void deleteBoardByBoardId(Post post);

}
