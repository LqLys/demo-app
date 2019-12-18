package com.example.demo.domain.post.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArchivedPostEntity {

    @Id
    private String id;
    private ArchivedPostValue archivedPost;
}
