/******************************
 * User: yuan
 * Date: 17-10-18 上午9:40
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package com.iaso.antibiotic.json;

import java.util.ArrayList;

public class DataSubgraph extends DataStatus{
    public DataSubgraph(int code, String msg) {
        super(code, msg);
        subgraphs = new ArrayList<Subgraph>();
    }

    private ArrayList<Subgraph> subgraphs;

    public ArrayList<Subgraph> getSubgraphs() {
        return subgraphs;
    }

    public void addSubgraph(String center) {
        subgraphs.add(new Subgraph(center));
    }

    public void addLink2Subgraph(String name, String relation) {
        subgraphs.get(subgraphs.size()-1).addLink(name, relation);
    }

    class Subgraph {

        private String center;
        private ArrayList<NodeAndRelation> linksWith;
        public Subgraph(String center) {
            this.center = center;
            linksWith = new ArrayList<NodeAndRelation>();
        }

        public String getCenter() {
            return center;
        }

        public ArrayList<NodeAndRelation> getLinksWith() {
            return linksWith;
        }

        public void addLink(String name, String relation) {
            linksWith.add(new NodeAndRelation(name, relation));
        }

        class NodeAndRelation {
            private String name;
            private String relation;

            public NodeAndRelation(String name, String relation) {
                this.name = name;
                this.relation = relation;
            }

            public String getName() {
                return name;
            }

            public String getRelation() {
                return relation;
            }
        }

    }
}
