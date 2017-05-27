package com.iaso.antibiotic.model;

public class InfectionSite {
    private String infectionSiteId;

    private String infectionSiteName;

    public String getInfectionSiteId() {
        return infectionSiteId;
    }

    public void setInfectionSiteId(String infectionSiteId) {
        this.infectionSiteId = infectionSiteId == null ? null : infectionSiteId.trim();
    }

    public String getInfectionSiteName() {
        return infectionSiteName;
    }

    public void setInfectionSiteName(String infectionSiteName) {
        this.infectionSiteName = infectionSiteName == null ? null : infectionSiteName.trim();
    }
}