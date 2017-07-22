package com.iaso.antibiotic.model;

import com.iaso.antibiotic.json.GNode;

public class SymptomType {
    private String symptomTypeId;

    private String symptomTypeName;

    private String typeName = "symptom_type"; //数据库名称，这个涉及数据库, 要将空格变为下划线

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

    public GNode symptomType2GNode(int group) {
        GNode node = new GNode(symptomTypeName, typeName, group);
        String infoStr = "<b>[Name]</b>" + symptomTypeName + "<br /><br /><b>[Type]</b> " + typeName;
        node.setInfos(infoStr);

        return node;
    }
}