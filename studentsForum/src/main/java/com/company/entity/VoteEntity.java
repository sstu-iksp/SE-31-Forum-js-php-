package com.company.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "vote", schema = "public", catalog = "StudentForumDB")
public class VoteEntity {
    private int id;
    private Integer objectId;
    private Object objectType;
    private boolean vote;
    private UserEntity userByUserId;
    private UserEntity userByUserId_0;

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
    @Column(name = "object_id")
    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    @Basic
    @Column(name = "object_type")
    public Object getObjectType() {
        return objectType;
    }

    public void setObjectType(Object objectType) {
        this.objectType = objectType;
    }

    @Basic
    @Column(name = "vote")
    public boolean isVote() {
        return vote;
    }

    public void setVote(boolean vote) {
        this.vote = vote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteEntity that = (VoteEntity) o;
        return vote == that.vote && Objects.equals(id, that.id) && Objects.equals(objectId, that.objectId) && Objects.equals(objectType, that.objectType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, objectId, objectType, vote);
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UserEntity getUserByUserId_0() {
        return userByUserId_0;
    }

    public void setUserByUserId_0(UserEntity userByUserId_0) {
        this.userByUserId_0 = userByUserId_0;
    }
}
