/******************************
 * User: yuan
 * Date: 17-10-10 下午4:14
 * Email: kq_yuan@outlook.com
 *
 * Description: 为API调用而写的持久层服务
 *
 ******************************/
package com.iaso.antibiotic.service;

import com.iaso.antibiotic.dao.*;
import com.iaso.antibiotic.exception.NoRelationsException;
import com.iaso.antibiotic.exception.NoSuchConceptException;
import com.iaso.antibiotic.json.DataLink;
import com.iaso.antibiotic.json.DataNode;
import com.iaso.antibiotic.json.DataSubgraph;
import com.iaso.antibiotic.json.GLink;
import com.iaso.antibiotic.model.KGRelation;
import org.omg.DynamicAny.NameDynAnyPair;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ApiService {
    //@Autowired
    private AntibioticDao antibioticDao = new AntibioticDao();

    //    @Autowired
    private BacteriaDao bacteriaDao = new BacteriaDao();

    //    @Autowired
    private SituationDao situationDao = new SituationDao();

    //    @Autowired
    private InfectionSiteDao infectionSiteDao = new InfectionSiteDao();

    //    @Autowired
    private DiseaseDao diseaseDao = new DiseaseDao();

    //    @Autowired
    private ComplicationDao complicationDao = new ComplicationDao();

    //    @Autowired
    private SymptomDao symptomDao = new SymptomDao();

    //    @Autowired
    private SymptomTypeDao symptomTypeDao = new SymptomTypeDao();

    private RelationDao relationDao = new RelationDao();
    
    private AntibioticService antibioticService = new AntibioticService();

    public DataNode getSingleNode(String dbName, String name) throws NullPointerException, NoSuchConceptException {
        Object data = null;
        if (dbName.equals("antibiotic")) {
            data = antibioticDao.findAntibioticByName(name);
        } else if (dbName.equals("bacteria")) {
            data = bacteriaDao.findBacteriaByName(name);
        } else if (dbName.equals("disease")) {
            data = diseaseDao.findDiseaseByName(name);
        } else if (dbName.equals("symptom")) {
            data = symptomDao.findSymptomByName(name);
        } else if (dbName.equals("infection_site")) {
            data = infectionSiteDao.findInfectionSiteByName(name);
        } else if (dbName.equals("symptom_type")) {
            data = symptomTypeDao.findSymptomTypeByName(name);
        } else if (dbName.equals("complication")) {
            data = complicationDao.findComplicationByName(name);
        } else if (dbName.equals("situation")) {
            data = situationDao.findSituationByName(name);
        } else {
            throw new NoSuchConceptException();
        }

        if (data == null)
            throw new NullPointerException();

        return new DataNode(0, "success", data);
    }

    public DataLink getSingleLink(String head, String tail) throws NullPointerException {
        KGRelation relationShip = null;
        DataLink dataLink = new DataLink(0, "success");
        ArrayList<InnerNode> headNodes = handleLinkNode(head);
        ArrayList<InnerNode> tailNodes = handleLinkNode(tail);
        for (InnerNode headNode: headNodes) {
            for (InnerNode tailNode: tailNodes) {
                try {
                    relationShip = findRelationType(headNode.id, tailNode.id);
                    HashMap<String, String> directedLink = confirmLinkDirection(relationShip, headNode, tailNode);
                    dataLink.addRelation(relationShip.getRelationId(), directedLink.get("head"),
                            directedLink.get("tail"), relationShip.getRelationType());
                } catch (NoRelationsException e) {
                    dataLink.addRelation("No relations");
                }

            }
        }

        return dataLink;
    }

    private ArrayList<InnerNode> handleLinkNode(String name) throws NullPointerException{
        List<Integer> dblist = antibioticDao.findDBNameByKeyword(name);
        if (dblist == null || dblist.size() == 0) // 不要忘了处理dblist的length为0的情况!!!
            throw new NullPointerException(name);
        
        ArrayList<InnerNode> nodeArrayList = new ArrayList<InnerNode>();
        for (Integer i: dblist)
            nodeArrayList.add(index2InnerNode(i, name));
        return nodeArrayList;
    }
    
/*
    // 不能处理同名节点
    public DataLink getSingleLink(String head, String tail) throws NullPointerException {
        KGRelation relationShip;
        InnerNode headNode = handleLinkNode(head);
        InnerNode tailNode = handleLinkNode(tail);
        try {
            relationShip = findRelationType(headNode.id, tailNode.id);
        } catch (NoRelationsException e) {
            return new DataLink(0, "success", "No relations");
        }

        HashMap<String, String> directedLink = confirmLinkDirection(relationShip, headNode, tailNode);
        return new DataLink(0, "success", relationShip.getRelationId(), directedLink.get("head"),
                             directedLink.get("tail"), relationShip.getRelationType());
    }

    private InnerNode handleLinkNode(String name) throws NullPointerException{
        List<Integer> dblist = antibioticDao.findDBNameByKeyword(name);
        if (dblist == null || dblist.size() == 0)
            throw new NullPointerException(name);
        // 处理dblist的length为0的情况
        return index2InnerNode(dblist.get(0), name);

    }
*/

    private InnerNode index2InnerNode(int i, String name) throws NullPointerException{
        switch (i) {
            case 1:
                return new InnerNode(antibioticDao.findAntibioticByName(name).getId(), "antibiotic", name);
            case 2:
                return new InnerNode(bacteriaDao.findBacteriaByName(name).getBacteriaId(), "bacteria", name);
            case 3:
                return new InnerNode(complicationDao.findComplicationByName(name).getComplicationId(), "complication", name);
            case 4:
                return new InnerNode(diseaseDao.findDiseaseByName(name).getId(), "disease", name);
            case 5:
                return new InnerNode(infectionSiteDao.findInfectionSiteByName(name).getInfectionSiteId(), "infection_site", name);
            case 6:
                return new InnerNode(situationDao.findSituationByName(name).getSituationId(), "situation", name);
            case 7:
                return new InnerNode(symptomDao.findSymptomByName(name).getSymptomId(), "symptom", name);
            case 8:
                return new InnerNode(symptomTypeDao.findSymptomTypeByName(name).getSymptomTypeId(), "symptom_type", name);
            default:
                throw new NullPointerException(name);
        }


    }

    private KGRelation findRelationType(String headId, String tailId) throws NoRelationsException{
        String relationId = antibioticDao.findEdgeByNodeIds(headId, tailId);
        if (relationId == null)
            throw new NoRelationsException();
        return relationDao.findRelationNameById(relationId);
    }

    private HashMap<String, String> confirmLinkDirection(KGRelation r, InnerNode node1, InnerNode node2) {
        HashMap<String, String> directedLink = new HashMap<String, String>();
        if (node1.type.equals(r.getSourceType())) {
            directedLink.put("head", node1.getName());
            directedLink.put("tail", node2.getName());

            return directedLink;
        }
        directedLink.put("head", node2.getName());
        directedLink.put("tail", node1.getName());

        return directedLink;
    }

    private class InnerNode {

        private String id;
        private String type;
        private String name;
        public InnerNode(String id, String type, String name) {
            this.id = id;
            this.type = type;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getType() {
            return type;
        }

        public String getName() {
            return name;
        }

    }
    
    public DataSubgraph getSubgraph(String center) throws NullPointerException{
        DataSubgraph dataSubgraph = new DataSubgraph(0, "success");
        List<Integer> dblist = antibioticDao.findDBNameByKeyword(center);
        for (Integer db: dblist) {
            dataSubgraph.addSubgraph(center);
            HashMap<String, Object> graphHashMap = handleSingleSubgraph(db, center);
            if (graphHashMap == null || !graphHashMap.containsKey("links"))  // 只有中心节点
                dataSubgraph.addSubgraph(center);
            else {
                List<GLink> links = (List<GLink>)graphHashMap.get("links");
                for (GLink gLink: links) {
                    String node = gLink.getTarget();
                    dataSubgraph.addLink2Subgraph(node, gLink.getLinkType());
                }

            }
        }

        if (dataSubgraph.getSubgraphs().size() > 0)
            return dataSubgraph;
        else throw new NullPointerException(center);
    }

    private HashMap<String, Object> handleSingleSubgraph(Integer db, String name) {
        switch (db) {
            case 1:
                return antibioticService.buildAntibioticGraph(name);
            case 2:
                return antibioticService.buildBacteriaGraph(name);
            case 3:
                return antibioticService.buildComplicationGraph(name);
            case 4:
                return antibioticService.buildDiseaseGraph(name);
            case 5:
                return antibioticService.buildInfectionSiteGraph(name);
            case 6:
                return antibioticService.buildSituationGraph(name);
            case 7:
                return antibioticService.buildSymptomGraph(name);
            case 8:
                return antibioticService.buildSymptomTypeGraph(name);
            default:
                return null;
        }
    }
}