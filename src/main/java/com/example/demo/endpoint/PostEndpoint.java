package com.example.demo.endpoint;

import com.example.demo.domain.post.dto.CreatePostDto;
import com.example.demo.domain.post.dto.PostDto;
import com.example.demo.domain.post.dto.RatedPostDto;
import com.example.demo.domain.post.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/post")
public class PostEndpoint {

    private final PostService postService;


    public PostEndpoint(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(path = "/")
    public List<PostDto> getPosts(){
        return postService.getAllPosts();
    }

    @PostMapping
    public PostDto createPost(@RequestBody CreatePostDto createPostDto){
        return postService.createPost(createPostDto);
    }

    @PostMapping(path = "/{postId}/archive")
    public void archivePost(@PathVariable("postId") Long postId){
        postService.archivePost(postId);
    }

    @GetMapping(path = "/{postId}")
    public RatedPostDto getPostWithReviews(@PathVariable("postId") Long postId){
        return postService.getRatedPost(postId);
    }
}
