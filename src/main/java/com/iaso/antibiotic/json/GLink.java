/******************************
 * User: yuan
 * Date: 17-7-2 上午11:41
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package com.iaso.antibiotic.json;

public class GLink {
    /**
     * 连接线类
     * 涵盖连线的基本信息：
     * ＠source：只有一个，即为查询的节点
     * ＠target
     * @linkType: 节点关系名称
     */
    private String source;
    private String target;
    private String linkType;

    /*public GLink(String source, String target, int value, String linkType) {
        this.source = source;
        this.target = target;
        this.value = value;
        this.linkType = linkType;
    }*/

    public GLink(String source, String target, String linkType) {
        this.source = source;
        this.target = target;
        this.linkType = linkType;
    }

    /*public GLink(String source, String target, int value) {
        this.source = source;
        this.target = target;
        this.value = value;
    }*/

    public GLink(String source, String target) {
        this.source = source;
        this.target = target;
    }

    public String getSource() {
        return source;
    }

    public String getTarget() {
        return target;
    }

    public String getLinkType() {
        return linkType;
    }
}
