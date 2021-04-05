package com.company.repository;

import com.company.model.Post;

import java.util.List;

public interface PostRepository {
    List<Post> getAllPosts();
    List<Post> getPostsByAuthorId(Long userId);
    void savePost(Post post);
    Post getPostById(Long id);
}
