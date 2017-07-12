package com.iaso.antibiotic.model;

import com.iaso.antibiotic.json.GNode;

public class Complication {
    private String complicationId;

    private String complicationName;

    private String typeName = "complication";

    public String getComplicationId() {
        return complicationId;
    }

    public void setComplicationId(String complicationId) {
        this.complicationId = complicationId == null ? null : complicationId.trim();
    }

    public String getComplicationName() {
        return complicationName;
    }

    public void setComplicationName(String complicationName) {
        this.complicationName = complicationName == null ? null : complicationName.trim();
    }

    public GNode complication2GNode(int group) {
        GNode node = new GNode(complicationName, "complication", group);
        String infoStr = "<b>[Name]</b>" + complicationName + "<br /><br /><b>[Type]</b> " + typeName;
        node.setInfos(infoStr);

        return node;
    }
}