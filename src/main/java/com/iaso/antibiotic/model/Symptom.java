package com.iaso.antibiotic.model;

import com.iaso.antibiotic.json.GNode;

public class Symptom {
    private String symptomId;

    private String symptomName;

    private String bodyPart;

    private String description;

    private String typeName = "symptom";

    public String getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(String symptomId) {
        this.symptomId = symptomId == null ? null : symptomId.trim();
    }

    public String getSymptomName() {
        return symptomName;
    }

    public void setSymptomName(String symptomName) {
        this.symptomName = symptomName == null ? null : symptomName.trim();
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart == null ? null : bodyPart.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public GNode symptom2GNode(int group) {
        GNode node = new GNode(symptomName, typeName, group);
        String infoStr = "<b>[Name]</b>" + symptomName + "<br /><br /><b>[Type]</b> " + typeName + "<br /><br /><b>[body part]</b> " + bodyPart
                + "<br /><br /><b>[Description]</b><br />" + this.getDescription();
        node.setInfos(infoStr);

        return node;
    }
}