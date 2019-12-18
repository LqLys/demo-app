package com.example.demo.domain.review.service;

import com.example.demo.domain.post.entity.PostEntity;
import com.example.demo.domain.post.exception.PostException;
import com.example.demo.domain.post.repository.PostRepository;
import com.example.demo.domain.review.dto.CreateReviewDto;
import com.example.demo.domain.review.dto.ReviewDto;
import com.example.demo.domain.review.entity.ReviewEntity;
import com.example.demo.domain.review.mapper.ReviewMapper;
import com.example.demo.domain.review.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final PostRepository postRepository;

    public ReviewService(ReviewRepository reviewRepository, ReviewMapper reviewMapper, PostRepository postRepository) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
        this.postRepository = postRepository;
    }


    public ReviewDto createPostReview(CreateReviewDto createReviewDto) {
        PostEntity post = postRepository.findById(createReviewDto.getPostId())
                .orElseThrow(() -> PostException.postNotFound(createReviewDto.getPostId()));

        ReviewEntity review = ReviewEntity.builder()
                .content(createReviewDto.getContent())
                .rating(createReviewDto.getRating())
                .title(createReviewDto.getTitle())
                .post(post)
                .build();

        return reviewMapper.entityToDto(reviewRepository.save(review));
    }

    @Transactional
    public Long deleteReview(Long reviewId) {
        return reviewRepository.deleteReviewById(reviewId);
    }
}
