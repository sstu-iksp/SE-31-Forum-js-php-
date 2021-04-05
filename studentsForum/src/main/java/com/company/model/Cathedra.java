package com.company.model;

public class Cathedra {
    private Long id;
    private String name;
    private Long instituteId;

    public Cathedra(Long id, String name, Long instituteId) {
        this.id = id;
        this.name = name;
        this.instituteId = instituteId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getInstituteId() {
        return instituteId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInstituteId(Long instituteId) {
        this.instituteId = instituteId;
    }
}
