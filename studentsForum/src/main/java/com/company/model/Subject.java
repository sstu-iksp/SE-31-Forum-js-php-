package com.company.model;

public class Subject {
    private Long id;
    private String name;
    private Integer groupId;

    public Subject(Long id, String name, Integer groupId) {
        this.id = id;
        this.name = name;
        this.groupId = groupId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}
