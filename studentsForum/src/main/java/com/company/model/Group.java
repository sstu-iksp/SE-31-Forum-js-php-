package com.company.model;

public class Group {
    private Long id;
    private Long cathedraId;
    private String name;
    private int course;

    public Group(Long id, Long cathedraId, String name, int course){
        this.id = id;
        this.cathedraId = cathedraId;
        this.name = name;
        this.course = course;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getCathedraId(){
        return cathedraId;
    }

    public void setCathedraId(Long cathedraId) { this.cathedraId = cathedraId; }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getCourse(){
        return course;
    }

    public void setCourse(int course){
        this.course = course;
    }
}
