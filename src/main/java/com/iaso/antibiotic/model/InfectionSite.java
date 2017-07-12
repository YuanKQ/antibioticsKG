package com.iaso.antibiotic.model;

import com.iaso.antibiotic.json.GNode;

public class InfectionSite {
    private String infectionSiteId;

    private String infectionSiteName;

    private String typeName = "infection_site";

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

    public GNode infectionSite2GNode(int group) {
        GNode node = new GNode(infectionSiteName, typeName, group);
        String infoStr = "<b>[Name]</b> " + infectionSiteName + "<br /><br /><b>[Type]</b>" + typeName.replace("_", " ");
        ;
        node.setInfos(infoStr);

        return node;
    }
}