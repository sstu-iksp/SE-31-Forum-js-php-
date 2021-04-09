package com.company.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "institute", schema = "public", catalog = "StudentForumDB")
public class InstituteEntity {
    private int id;
    private String name;
    private CathedraEntity cathedraById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstituteEntity that = (InstituteEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @OneToOne(mappedBy = "instituteById")
    public CathedraEntity getCathedraById() {
        return cathedraById;
    }

    public void setCathedraById(CathedraEntity cathedraById) {
        this.cathedraById = cathedraById;
    }
}
