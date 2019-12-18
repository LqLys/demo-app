package com.example.demo.domain.review.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArchivedReviewValue {

    private Long id;
    private String title;
    private String content;
    private Integer rating;
}
