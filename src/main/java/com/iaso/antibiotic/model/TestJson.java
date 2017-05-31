/******************************
 * User: yuan
 * Date: 17-5-30 下午4:37
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package com.iaso.antibiotic.model;

public class TestJson {
    private String keyword;
    private String graph;

    public String getKeyword() {
        return keyword;
    }

    public String getGraph() {
        return graph;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setGraph(String graph) {
        this.graph = graph;
    }

    public TestJson(String keyword, String graph) {
        this.keyword = keyword;
        this.graph = graph;
    }
}
