package com.example.demo.domain.review.entity;

import com.example.demo.domain.post.entity.PostEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="REVIEW")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class ReviewEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Id
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "RATING")
    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private PostEntity post;
}
