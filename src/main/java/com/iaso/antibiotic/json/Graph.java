/******************************
 * User: yuan
 * Date: 17-7-2 上午10:27
 * Email: kq_yuan@outlook.com
 *
 * Description: [drop]构建d3.js在展示时的JSON类
 *
 ******************************/
package com.iaso.antibiotic.json;

import java.util.ArrayList;

public class Graph {
    private ArrayList<GNode> nodes = new ArrayList<GNode>();
    private ArrayList<GLink> links = new ArrayList<GLink>();
    private String keyword;
    private String Graph;

    public Graph(String keyword, String graph) {
        this.keyword = keyword;
        Graph = graph;
    }

    public Graph(String keyword) {
        this.keyword = keyword;
    }

    public Graph() {
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setGraph(String graph) {
        Graph = graph;
    }

    public ArrayList<GLink> getLinks() {
        return links;
    }

    public void setLinks(ArrayList<GLink> links) {
        this.links = links;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getGraph() {
        return Graph;
    }

    public ArrayList<GNode> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<GNode> nodes) {
        this.nodes = nodes;
    }
}
