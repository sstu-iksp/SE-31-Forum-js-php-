package com.company.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "cathedra", schema = "public", catalog = "StudentForumDB")
public class CathedraEntity {
    private int id;
    private int instituteId;
    private String name;
    private Collection<GroupEntity> groupsById;
    private InstituteEntity instituteById;

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
    @Column(name = "institute_id")
    public int getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(int instituteId) {
        this.instituteId = instituteId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CathedraEntity that = (CathedraEntity) o;
        return instituteId == that.instituteId && Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, instituteId, name);
    }

    @OneToMany(mappedBy = "cathedraByCathedraId")
    public Collection<GroupEntity> getGroupsById() {
        return groupsById;
    }

    public void setGroupsById(Collection<GroupEntity> groupsById) {
        this.groupsById = groupsById;
    }

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    public InstituteEntity getInstituteById() {
        return instituteById;
    }

    public void setInstituteById(InstituteEntity instituteById) {
        this.instituteById = instituteById;
    }
}
