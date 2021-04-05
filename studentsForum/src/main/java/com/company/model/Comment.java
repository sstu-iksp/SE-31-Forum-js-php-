package com.company.model;

public class Comment {
    private Long id;
    private String commentText;
    private Long postId;
    private Long userId;

    public Comment(Long id, String commentText, Long postId, Long userId){
        this.id = id;
        this.commentText = commentText;
        this.postId = postId;
        this.userId = userId;
    }

    public Long getId(){ return id; }

    public void setId(Long id){ this.id = id; }

    public String getCommentText(){ return commentText; }

    public void setCommentText(String commentText){ this.commentText = commentText; }

    public Long getPostId() { return postId; }

    public void setPostId(Long postId) { this.postId = postId; }

    public Long getUserId() { return userId; }

    public void setUserId(Long userId) { this.userId = userId; }
}
