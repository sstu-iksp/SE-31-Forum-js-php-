package com.company.model;

public class Vote {
    private Long id;
    private Long userId;
    private Long objectId;
    private String objectType;
    private Boolean vote;

    public Vote(Long id, Long userId, Long objectId, String objectType, Boolean vote) {
        this.id = id;
        this.userId = userId;
        this.objectId = objectId;
        this.objectType = objectType;
        this.vote = vote;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getObjectId() {
        return objectId;
    }

    public String getObjectType() {
        return objectType;
    }

    public Boolean getVote() {
        return vote;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public void setVote(Boolean vote) {
        this.vote = vote;
    }
}
