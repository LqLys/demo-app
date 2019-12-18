package com.example.demo.domain.post.entity;

import com.example.demo.domain.review.entity.ArchivedReviewValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArchivedPostValue {

    private Long id;
    private String title;
    private String content;
    private List<ArchivedReviewValue> reviews;
}
