package com.example.demo12.service;

import com.example.demo12.mapper.ReviewMapper;
import com.example.demo12.model.Course;
import com.example.demo12.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;

    public List<Review> getReviewList(){
        return reviewMapper.getReviews();
    }
    public void addReview(Review review){
        reviewMapper.insertReview(review);
    }
    public Review getReviewByReviewNo(int review){
        return reviewMapper.getReviewByReviewNo(review);
    }
    public void updateReview(Review review){
        reviewMapper.updateReviewByReviewId(review);
    }
    public void deleteReview(Review review){
        reviewMapper.deleteReviewByReviewId(review);
    }
    public void addReferenceNo(Review review) {
        reviewMapper.updateReviewReferenceNo(review);
    }

}
