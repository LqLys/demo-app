package com.example.demo.endpoint;

import com.example.demo.domain.review.dto.CreateReviewDto;
import com.example.demo.domain.review.dto.ReviewDto;
import com.example.demo.domain.review.service.ReviewService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewEndpoint {

    private final ReviewService reviewService;

    public ReviewEndpoint(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ReviewDto createPostReview(@RequestBody CreateReviewDto createReviewDto){
        return reviewService.createPostReview(createReviewDto);
    }

    @DeleteMapping(path = "/{reviewId}")
    public Long deleteReview(@PathVariable("reviewId") Long reviewId){
        return reviewService.deleteReview(reviewId);
    }
}
