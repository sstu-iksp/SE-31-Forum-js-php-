package com.company.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "_user", schema = "public", catalog = "StudentForumDB")
public class UserEntity {
    private int id;
    private String firstName;
    private String secondName;
    private String login;
    private String password;
    private String email;
    private String telegram;
    private String imagePhoto;
    private GroupEntity groupByGroupId;
    private Collection<CommentEntity> commentsById;
    private Collection<PostEntity> postsById;
    private Collection<VoteEntity> votesById;
    private Collection<VoteEntity> votesById_0;

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
    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "secondName")
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "telegram")
    public String getTelegram() {
        return telegram;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
    }

    @Basic
    @Column(name = "image_photo")
    public String getImagePhoto() {
        return imagePhoto;
    }

    public void setImagePhoto(String imagePhoto) {
        this.imagePhoto = imagePhoto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(secondName, that.secondName) && Objects.equals(login, that.login) && Objects.equals(password, that.password) && Objects.equals(email, that.email) && Objects.equals(telegram, that.telegram) && Objects.equals(imagePhoto, that.imagePhoto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, login, password, email, telegram, imagePhoto);
    }

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = false)
    public GroupEntity getGroupByGroupId() {
        return groupByGroupId;
    }

    public void setGroupByGroupId(GroupEntity groupByGroupId) {
        this.groupByGroupId = groupByGroupId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<CommentEntity> getCommentsById() {
        return commentsById;
    }

    public void setCommentsById(Collection<CommentEntity> commentsById) {
        this.commentsById = commentsById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<PostEntity> getPostsById() {
        return postsById;
    }

    public void setPostsById(Collection<PostEntity> postsById) {
        this.postsById = postsById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<VoteEntity> getVotesById() {
        return votesById;
    }

    public void setVotesById(Collection<VoteEntity> votesById) {
        this.votesById = votesById;
    }

    @OneToMany(mappedBy = "userByUserId_0")
    public Collection<VoteEntity> getVotesById_0() {
        return votesById_0;
    }

    public void setVotesById_0(Collection<VoteEntity> votesById_0) {
        this.votesById_0 = votesById_0;
    }
}
