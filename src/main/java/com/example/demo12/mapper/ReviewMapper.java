package com.example.demo12.mapper;

import com.example.demo12.model.Course;
import com.example.demo12.model.Review;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ReviewMapper {
    List<Review> getReviews();
    void insertReview(Review review);
    Review getReviewByReviewNo(int review);
    void updateReviewByReviewId(Review review);
    void deleteReviewByReviewId(Review review);

    void updateReviewReferenceNo(Review review);

    void updateReviewRecommend(Review review);
}
