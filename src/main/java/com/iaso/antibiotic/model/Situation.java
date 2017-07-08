package com.iaso.antibiotic.model;

import com.iaso.antibiotic.json.GNode;

import java.util.HashMap;

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

    public GNode situation2GNode(int group) {
        GNode node = new GNode(this.situationName, "situation", group);

        HashMap<String, String> infos = new HashMap<String, String>();
        String infoStr = "<b>[Name]</b>" + this.situationName + "<br /><br /><b>[Type]</b> Situation ";
        node.setInfos(infoStr);

        return node;
    }
}