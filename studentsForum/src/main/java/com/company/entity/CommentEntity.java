package com.company.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comment", schema = "public", catalog = "StudentForumDB")
public class CommentEntity {
    private int id;
    private String commentText;
    private PostEntity postByPostId;
    private UserEntity userByUserId;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "comment_text")
    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentEntity that = (CommentEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(commentText, that.commentText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, commentText);
    }

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false)
    public PostEntity getPostByPostId() {
        return postByPostId;
    }

    public void setPostByPostId(PostEntity postByPostId) {
        this.postByPostId = postByPostId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }
}
