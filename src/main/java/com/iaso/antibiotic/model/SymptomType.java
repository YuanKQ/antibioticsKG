package com.iaso.antibiotic.model;

public class SymptomType {
    private String symptomTypeId;

    private String symptomTypeName;

    public String getSymptomTypeId() {
        return symptomTypeId;
    }

    public void setSymptomTypeId(String symptomTypeId) {
        this.symptomTypeId = symptomTypeId == null ? null : symptomTypeId.trim();
    }

    public String getSymptomTypeName() {
        return symptomTypeName;
    }

    public void setSymptomTypeName(String symptomTypeName) {
        this.symptomTypeName = symptomTypeName == null ? null : symptomTypeName.trim();
    }
}