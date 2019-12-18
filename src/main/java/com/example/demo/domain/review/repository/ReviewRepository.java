package com.example.demo.domain.review.repository;

import com.example.demo.domain.review.entity.ReviewEntity;
import com.example.demo.domain.review.repository.fragment.ReviewRepositoryFragment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long>, ReviewRepositoryFragment {
}
