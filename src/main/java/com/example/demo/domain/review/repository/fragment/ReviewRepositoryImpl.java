package com.example.demo.domain.review.repository.fragment;

import com.example.demo.domain.review.entity.QReviewEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class ReviewRepositoryImpl implements ReviewRepositoryFragment {

    private final JPAQueryFactory jpaQueryFactory;

    public ReviewRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }


    @Override
    public Long deleteReviewById(Long reviewId) {
        QReviewEntity review = QReviewEntity.reviewEntity;
        return jpaQueryFactory.delete(review).where(review.id.eq(reviewId)).execute();
    }
}
