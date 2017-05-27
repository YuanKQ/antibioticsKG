package com.iaso.antibiotic.model;

public class Complication {
    private String complicationId;

    private String complicationName;

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
}