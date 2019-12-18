package com.example.demo.domain.post.dto;

import com.example.demo.domain.review.dto.RatedPostReviewDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RatedPostDto {
    private Long id;
    private String title;
    private String content;
    private BigDecimal averageRating;
    private List<RatedPostReviewDto> reviews;
}
