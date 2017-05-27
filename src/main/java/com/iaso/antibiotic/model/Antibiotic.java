/******************************
 * User: yuan
 * Date: 17-5-24 下午8:58
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package com.iaso.antibiotic.model;

public class Antibiotic {
    private String id;
    private String name;
    private String type = null;
    private String description = null;
    private String drug_indication = null;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getDrug_indication() {
        return drug_indication;
    }

    public Antibiotic() {
    }

    public Antibiotic(String id, String name, String type, String description, String drug_indication) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.drug_indication = drug_indication;
    }

    public Antibiotic(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Antibiotic(Antibiotic antibiotic) {
        this.id = antibiotic.id;
        this.name = antibiotic.name;
        this.type = antibiotic.type;
        this.description = antibiotic.description;
        this.drug_indication = antibiotic.drug_indication;
    }
}
