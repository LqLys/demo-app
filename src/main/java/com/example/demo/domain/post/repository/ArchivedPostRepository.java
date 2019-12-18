package com.example.demo.domain.post.repository;

import com.example.demo.domain.post.entity.ArchivedPostEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArchivedPostRepository extends MongoRepository<ArchivedPostEntity, String> {
}
