package com.example.demo.domain.post.exception;

public class PostException extends RuntimeException {

    private PostException(String message) {
        super(message);
    }

    public static PostException postNotFound(Long postId){
        return new PostException(String.format("Post with id %s does not exist", postId));
    }
}
