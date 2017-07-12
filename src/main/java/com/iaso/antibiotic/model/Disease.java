package com.iaso.antibiotic.model;

import com.iaso.antibiotic.json.GNode;

public class Disease {
    private String diseaseId;

    private String diseaseName;

    private String typeName = "disease";

    public String getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(String diseaseId) {
        this.diseaseId = diseaseId == null ? null : diseaseId.trim();
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName == null ? null : diseaseName.trim();
    }

    public GNode disease2GNode(int group) {
        GNode node = new GNode(diseaseName, typeName, group);
        String infoStr = "<b>[Name]</b> " + diseaseName + "<br /><br /><b>[Type]</b>" + typeName;
        node.setInfos(infoStr);

        return node;
    }

    public String getId() {
        return diseaseId;
    }
}