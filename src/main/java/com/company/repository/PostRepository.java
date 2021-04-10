package com.company.repository;

import com.company.model.Post;

import java.util.List;

public interface PostRepository {
    List<Post> findAll();
    void save(Post post);
}
