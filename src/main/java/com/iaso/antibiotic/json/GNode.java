/******************************
 * User: yuan
 * Date: 17-7-2 上午11:36
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package com.iaso.antibiotic.json;

import java.io.Serializable;
import java.util.ArrayList;

public class GNode implements Serializable {
    /**
     * 节点类
     * 涵盖节点基本信息：
     * ＠id：初步定为药物名称
     * ＠infos：所涵盖信息因节点类型而定
     * - Antibiotic(name, type, description, drug_indication)
     * - Bacteria(name, type, description)
     * - Situtation(name)
     * ＠group：决定节点颜色，不同类别应该有不同的颜色
     */
    private String id;
    private String infos;
    private int group;

    public GNode(String id, int group) {
        this.id = id;
        this.group = group;
    }

    public String getInfos() {
        return infos;
    }

    public void setInfos(String infos) {
        this.infos = infos;
    }

    public String getId() {
        return id;
    }

    public int getGroup() {
        return group;
    }
}
