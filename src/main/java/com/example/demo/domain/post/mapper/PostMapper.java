package com.example.demo.domain.post.mapper;

import com.example.demo.domain.post.dto.CreatePostDto;
import com.example.demo.domain.post.dto.PostDto;
import com.example.demo.domain.post.dto.RatedPostDto;
import com.example.demo.domain.post.entity.ArchivedPostValue;
import com.example.demo.domain.post.entity.PostEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {

    PostDto entityToDto(PostEntity postEntity);
    PostEntity dtoToEntity(PostDto postDto);
    PostEntity createPostToEntity(CreatePostDto createPostDto);
    RatedPostDto postEntToPostWithReviews(PostEntity postEntity);
    ArchivedPostValue postEntToArchivedVal(PostEntity postEntity);
}
