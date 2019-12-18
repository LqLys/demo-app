package com.example.demo.domain.post.service;

import com.example.demo.domain.post.dto.CreatePostDto;
import com.example.demo.domain.post.dto.PostDto;
import com.example.demo.domain.post.dto.RatedPostDto;
import com.example.demo.domain.post.entity.ArchivedPostEntity;
import com.example.demo.domain.post.entity.ArchivedPostValue;
import com.example.demo.domain.post.entity.PostEntity;
import com.example.demo.domain.post.exception.PostException;
import com.example.demo.domain.post.mapper.PostMapper;
import com.example.demo.domain.post.repository.ArchivedPostRepository;
import com.example.demo.domain.post.repository.PostRepository;
import com.example.demo.domain.review.dto.RatedPostReviewDto;
import com.example.demo.domain.review.entity.ReviewEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final ArchivedPostRepository archivedPostRepository;
    private final ObjectMapper objectMapper;

    public PostService(PostRepository postRepository, PostMapper postMapper, ArchivedPostRepository archivedPostRepository, ObjectMapper objectMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
        this.archivedPostRepository = archivedPostRepository;
        this.objectMapper = objectMapper;
    }


    public List<PostDto> getAllPosts() {
        return postRepository.findAll().stream()
                .map(postMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public PostDto createPost(CreatePostDto createPostDto) {
        return postMapper.entityToDto(postRepository.save(postMapper.createPostToEntity(createPostDto)));
    }

    @Transactional
    public void archivePost(Long postId) {
        PostEntity post = postRepository.findById(postId)
                .orElseThrow(() -> PostException.postNotFound(postId));

        ArchivedPostValue archivedPostValue = postMapper.postEntToArchivedVal(post);
        ArchivedPostEntity archivedPostEntity = ArchivedPostEntity.builder().archivedPost(archivedPostValue).build();

        archivedPostRepository.save(archivedPostEntity);
        postRepository.delete(post);
    }

    public RatedPostDto getRatedPost(Long postId) {
        PostEntity post = postRepository.findById(postId)
                .orElseThrow(() -> PostException.postNotFound(postId));

        RatedPostDto ratedPostDto = postMapper.postEntToPostWithReviews(post);
        BigDecimal averageRating = getAverageRating(ratedPostDto);
        ratedPostDto.setAverageRating(averageRating);

        return ratedPostDto;
    }

    private BigDecimal getAverageRating(RatedPostDto ratedPostDto) {
        final List<RatedPostReviewDto> reviews = ratedPostDto.getReviews();
        final int ratingSum = reviews.stream()
                .mapToInt(RatedPostReviewDto::getRating)
                .sum();
        final int denominator = reviews.size() > 0 ? reviews.size() : 1;
        return BigDecimal.valueOf(ratingSum / denominator);
    }
}
