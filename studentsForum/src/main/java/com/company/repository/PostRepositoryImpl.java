package com.company.repository;

import com.company.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostRepositoryImpl implements PostRepository {
    private List<Post> posts = new ArrayList<>();

    @Override
    public List<Post> getAllPosts() {
        return posts;
    }

    @Override
    public List<Post> getPostsByAuthorId(Long userId) {
        ArrayList<Post> result = new ArrayList<>();

        for (Post post : posts) {
               if (post.getAuthorId().equals(userId)) {
                   result.add(post);
               }
        }

        return result;
    }

    @Override
    public void savePost(Post post) {
        posts.add(post);
    }

    @Override
    public Post getPostById(Long id) {
        for (Post post: posts) {
            if (post.getId().equals(id))
                return post;
        }
        throw new IllegalArgumentException("Post with id " + id + " was not found");
    }
}
