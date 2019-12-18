package com.example.demo.domain.review.mapper;

import com.example.demo.domain.review.dto.ReviewDto;
import com.example.demo.domain.review.entity.ReviewEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    @Mappings({
            @Mapping(target="postId", source="reviewEntity.post.id"),
    })
    ReviewDto entityToDto(ReviewEntity reviewEntity);
    ReviewEntity dtoToEntity(ReviewDto postDto);
}
