package com.company.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "_group", schema = "public", catalog = "StudentForumDB")
public class GroupEntity {
    private int id;
    private String name;
    private int course;
    private CathedraEntity cathedraByCathedraId;
    private Collection<UserEntity> usersById;
    private Collection<SubjectEntity> subjectsById;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "course")
    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupEntity that = (GroupEntity) o;
        return course == that.course && Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, course);
    }

    @ManyToOne
    @JoinColumn(name = "cathedra_id", referencedColumnName = "id", nullable = false)
    public CathedraEntity getCathedraByCathedraId() {
        return cathedraByCathedraId;
    }

    public void setCathedraByCathedraId(CathedraEntity cathedraByCathedraId) {
        this.cathedraByCathedraId = cathedraByCathedraId;
    }

    @OneToMany(mappedBy = "groupByGroupId")
    public Collection<UserEntity> getUsersById() {
        return usersById;
    }

    public void setUsersById(Collection<UserEntity> usersById) {
        this.usersById = usersById;
    }

    @OneToMany(mappedBy = "groupByGroupId")
    public Collection<SubjectEntity> getSubjectsById() {
        return subjectsById;
    }

    public void setSubjectsById(Collection<SubjectEntity> subjectsById) {
        this.subjectsById = subjectsById;
    }
}
