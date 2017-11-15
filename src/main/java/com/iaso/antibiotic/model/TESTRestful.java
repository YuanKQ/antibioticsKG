package com.iaso.antibiotic.model;

public class TESTRestful {
    private Integer id;

    private String name;

    private Double property;

    private String description;

    // Default Constructor is needed. Otherwise, [Error Msg]The request sent by the client was syntactically incorrect
    public TESTRestful() {
    }

    // 其他构造器与POST请求中@RequestBody无关, 依后台实际开发需要
    public TESTRestful(Integer id, String name, Double property, String description) {
        this.id = id;
        this.name = name;
        this.property = property;
        this.description = description;
    }

    public TESTRestful(Integer id, String name, Double property) {
        this.id = id;
        this.name = name;
        this.property = property;
    }

    public TESTRestful(String name, Double property, String description) {
        this.name = name;
        this.property = property;
        this.description = description;
    }

    public TESTRestful(String name, Double property) {
        this.name = name;
        this.property = property;
    }

    public TESTRestful(String name) {
        this.name = name;
    }

    public TESTRestful(Integer id, TESTRestful other) {
        this.id = id;
        this.name = other.getName();
        this.property = other.getProperty();
        this.description = other.getDescription();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getProperty() {
        return property;
    }

    public void setProperty(Double property) {
        this.property = property;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}