package com.iaso.antibiotic.model;

public class Bacteria {
    private String bacteriaId;

    private String bacteriaName;

    private String bacteriaType;

    private String description;

    public String getBacteriaId() {
        return bacteriaId;
    }

    public void setBacteriaId(String bacteriaId) {
        this.bacteriaId = bacteriaId == null ? null : bacteriaId.trim();
    }

    public String getBacteriaName() {
        return bacteriaName;
    }

    public void setBacteriaName(String bacteriaName) {
        this.bacteriaName = bacteriaName == null ? null : bacteriaName.trim();
    }

    public String getBacteriaType() {
        return bacteriaType;
    }

    public void setBacteriaType(String bacteriaType) {
        this.bacteriaType = bacteriaType == null ? null : bacteriaType.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}