package com.example.demo.domain.review.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {
    private Long id;
    private String title;
    private String content;
    private Integer rating;
    private Long postId;
}
