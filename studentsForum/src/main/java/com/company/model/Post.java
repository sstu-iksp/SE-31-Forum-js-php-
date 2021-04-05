package com.company.model;

public class Post {
    private Long id;
    private String title;
    private String text;
    private Long subjectId;
    private Long authorId;

    public Post(Long id, String title, String text, Long subjectId, Long authorId) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.subjectId = subjectId;
        this.authorId = authorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
