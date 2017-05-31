package com.iaso.antibiotic.model;

public class Situation {
    private String situationId;

    private String situationName;

    public String getSituationId() {
        return situationId;
    }

    public void setSituationId(String situationId) {
        this.situationId = situationId == null ? null : situationId.trim();
    }

    public String getSituationName() {
        return situationName;
    }

    public void setSituationName(String situationName) {
        this.situationName = situationName == null ? null : situationName.trim();
    }
}