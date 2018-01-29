/******************************
 * User: yuan
 * Date: 17-5-24 下午10:37
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package com.iaso.antibiotic.service;

import com.iaso.antibiotic.dao.*;
import com.iaso.antibiotic.json.GLink;
import com.iaso.antibiotic.json.GNode;
import com.iaso.antibiotic.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

enum NodeTypeEnum {
    SourceNode, AntibioticNode, BacteriaNode, ComplicationNode, DiseaseNode, InfectionSiteNode, SituationNode,
    SymptomNode, SymptomTypeNode
}

enum LinkTypeEnum {
    AntibioticToBacteria, AntibioticToSituation, AntibioticToAntibiotic, DiseaseToComplication,
    DiseaseToBacteria, BacteriaToInfectionSite, SymptomTypeToSymptomType, SymptomToSymptomType, DiseaseToSymptom
}

@Component
public class AntibioticService {

    @Autowired
//    private AntibioticDao antibioticDao = new AntibioticDao();
    private AntibioticDao antibioticDao;
    @Autowired
    private BacteriaDao bacteriaDao;

    @Autowired
    private SituationDao situationDao;

    @Autowired
    private InfectionSiteDao infectionSiteDao;

    @Autowired
    private DiseaseDao diseaseDao;

    @Autowired
    private ComplicationDao complicationDao;

    @Autowired
    private SymptomDao symptomDao;

    @Autowired
    private SymptomTypeDao symptomTypeDao;

    /*
     * build a subgraph consists of directly related nodes to the center of the graph
     *
     * write for SearchController.java
     * */
    private HashMap<String, Object> createGraphMap(List<GNode> nodeList, List<GLink> linkList, int max) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("nodes", nodeList);
        map.put("links", linkList);
        map.put("totalGroup", max);
        map.put("status", 200);

        return map;
    }

    private HashMap<String, Object> createSingleNodeGraphMap(GNode gNode) {
        List<GNode> nodeList = new ArrayList<GNode>();
        List<GLink> linkList = new ArrayList<GLink>();
        int totalGroup = 0;

        nodeList.add(gNode);

        return createGraphMap(nodeList, linkList, totalGroup);
    }

    public HashMap<String, Object> buildBacteriaGraph(String name) throws NullPointerException {
        Bacteria bacteria = bacteriaDao.findBacteriaByName(name);
        if (bacteria == null)
            throw new NullPointerException("The bacteria node can't be found. ");

        List<String> idList = antibioticDao.findAllNodeID(bacteria.getBacteriaId());
        if (idList.size() == 0)
            return createSingleNodeGraphMap(bacteria.bacteria2GNode(NodeTypeEnum.SourceNode.ordinal()));

        List<Disease> diseaseList = diseaseDao.findDiseaseByIdList(idList);
        List<InfectionSite> infectionSiteList = infectionSiteDao.findInfectionSiteByID(idList);
        List<Antibiotic> antibioticList = antibioticDao.findAntibioticByID("", idList);

        List<GNode> nodeList = new ArrayList<GNode>();
        List<GLink> linkList = new ArrayList<GLink>();
        int totalGroup = 3;

        GNode sourceNode = bacteria.bacteria2GNode(NodeTypeEnum.SourceNode.ordinal());
        nodeList.add(sourceNode);
        for (Antibiotic a : antibioticList) {
            GNode node = a.antibiotic2GNode(NodeTypeEnum.AntibioticNode.ordinal());
            nodeList.add(node);
            linkList.add(new GLink(sourceNode.getId(), node.getId(), LinkTypeEnum.AntibioticToBacteria.toString()));
        }

        for (Disease d : diseaseList) {
            GNode node = d.disease2GNode(NodeTypeEnum.DiseaseNode.ordinal());
            nodeList.add(node);
            linkList.add(new GLink(sourceNode.getId(), node.getId(), LinkTypeEnum.DiseaseToBacteria.toString()));
        }

        for (InfectionSite site : infectionSiteList) {
            GNode node = site.infectionSite2GNode(NodeTypeEnum.InfectionSiteNode.ordinal());
            nodeList.add(node);
            linkList.add(new GLink(sourceNode.getId(), node.getId(), LinkTypeEnum.BacteriaToInfectionSite.toString()));
        }

        return createGraphMap(nodeList, linkList, totalGroup);
    }

    public HashMap<String, Object> buildAntibioticGraph(String name) throws NullPointerException {
        Antibiotic antibiotic = antibioticDao.findAntibioticByName(name);
        if (antibiotic == null)
            throw new NullPointerException("The antibiotic node can't be found. ");

        List<String> idList = antibioticDao.findAllNodeID(antibiotic.getId());
        if (idList.size() == 0)
            return createSingleNodeGraphMap(antibiotic.antibiotic2GNode(NodeTypeEnum.SourceNode.ordinal()));

        List<Bacteria> bacteriaList = bacteriaDao.findBacteriaByID(idList);
        List<Situation> situationList = situationDao.findSituationByID(idList);
        List<Antibiotic> antibioticList = antibioticDao.findAntibioticByID(antibiotic.getId(), idList);

        List<GNode> nodeList = new ArrayList<GNode>();
        List<GLink> linkList = new ArrayList<GLink>();
        int totalGroup = 3;

        GNode sourceNode = antibiotic.antibiotic2GNode(NodeTypeEnum.SourceNode.ordinal());
        nodeList.add(sourceNode);
        for (Antibiotic a : antibioticList) {
            GNode node = a.antibiotic2GNode(NodeTypeEnum.AntibioticNode.ordinal());
            nodeList.add(node);
            linkList.add(new GLink(sourceNode.getId(), node.getId(), LinkTypeEnum.AntibioticToAntibiotic.toString()));
        }

        for (Bacteria b : bacteriaList) {
            GNode node = b.bacteria2GNode(NodeTypeEnum.BacteriaNode.ordinal());
            nodeList.add(node);
            linkList.add(new GLink(sourceNode.getId(), node.getId(), LinkTypeEnum.AntibioticToBacteria.toString()));
        }

        for (Situation s : situationList
                ) {
            GNode node = s.situation2GNode(NodeTypeEnum.SituationNode.ordinal());
            nodeList.add(node);
            linkList.add(new GLink(sourceNode.getId(), node.getId(), LinkTypeEnum.AntibioticToSituation.toString()));
        }

        return createGraphMap(nodeList, linkList, totalGroup);
    }

    public HashMap<String, Object> buildDiseaseGraph(String name) throws NullPointerException {
        Disease disease = diseaseDao.findDiseaseByName(name);
        if (disease == null)
            throw new NullPointerException("The disease node can't be found. ");

        List<String> idList = antibioticDao.findAllNodeID(disease.getId());
        if (idList.size() == 0)
            return createSingleNodeGraphMap(disease.disease2GNode(NodeTypeEnum.SourceNode.ordinal()));

        List<Bacteria> bacteriaList = bacteriaDao.findBacteriaByID(idList);
        List<Complication> complicationList = complicationDao.findComplicationByIdList(idList);
        List<Symptom> symptomList = symptomDao.findSymptomByIdList(idList);

        List<GNode> nodeList = new ArrayList<GNode>();
        List<GLink> linkList = new ArrayList<GLink>();
        int totalGroup = 3;

        GNode sourceNode = disease.disease2GNode(NodeTypeEnum.SourceNode.ordinal());
        nodeList.add(sourceNode);
        for (Complication c : complicationList) {
            GNode node = c.complication2GNode(NodeTypeEnum.ComplicationNode.ordinal());
            nodeList.add(node);
            linkList.add(new GLink(disease.getDiseaseName(), c.getComplicationName(), LinkTypeEnum.DiseaseToComplication.toString()));
        }

        for (Bacteria b : bacteriaList) {
            GNode node = b.bacteria2GNode(NodeTypeEnum.BacteriaNode.ordinal());
            nodeList.add(node);
            linkList.add(new GLink(disease.getDiseaseName(), b.getBacteriaName(), LinkTypeEnum.DiseaseToBacteria.toString()));
        }

        for (Symptom s : symptomList
                ) {
            GNode node = s.symptom2GNode(NodeTypeEnum.SymptomNode.ordinal());
            nodeList.add(node);
            linkList.add(new GLink(disease.getDiseaseName(), s.getSymptomName(), LinkTypeEnum.DiseaseToSymptom.toString()));
        }

        return createGraphMap(nodeList, linkList, totalGroup);
    }

    public HashMap<String, Object> buildSymptomGraph(String name) throws NullPointerException {
        Symptom symptom = symptomDao.findSymptomByName(name);
        if (symptom == null)
            throw new NullPointerException("The symptom node can't be found. ");

        List<String> idList = antibioticDao.findAllNodeID(symptom.getSymptomId());
        if (idList.size() == 0)
            return createSingleNodeGraphMap(symptom.symptom2GNode(NodeTypeEnum.SourceNode.ordinal()));

        List<Disease> diseaseList = diseaseDao.findDiseaseByIdList(idList);
        List<SymptomType> symptomTypeList = symptomTypeDao.findSymptomTypeByIdList(idList);

        List<GNode> nodeList = new ArrayList<GNode>();
        List<GLink> linkList = new ArrayList<GLink>();
        int totalGroup = 4;

        GNode sourceNode = symptom.symptom2GNode(NodeTypeEnum.SourceNode.ordinal());
        nodeList.add(sourceNode);
        for (Disease d : diseaseList
                ) {
            GNode node = d.disease2GNode(NodeTypeEnum.DiseaseNode.ordinal());
            nodeList.add(node);
            linkList.add(new GLink(symptom.getSymptomName(), d.getDiseaseName(), LinkTypeEnum.DiseaseToSymptom.toString()));
        }

        for (SymptomType st : symptomTypeList
                ) {
            GNode node = st.symptomType2GNode(NodeTypeEnum.SymptomTypeNode.ordinal());
            nodeList.add(node);
            linkList.add(new GLink(symptom.getSymptomName(), st.getSymptomTypeName(), LinkTypeEnum.SymptomToSymptomType.toString()));

            List<String> idList2 = antibioticDao.findAllNodeID(st.getSymptomTypeId());
            List<SymptomType> symptomTypeList2 = symptomTypeDao.findSymptomTypeByIdList(idList2);

            for (SymptomType st2 : symptomTypeList2
                    ) {
                GNode node1 = st2.symptomType2GNode(NodeTypeEnum.SymptomTypeNode.ordinal());
                nodeList.add(node1);
                linkList.add(new GLink(st.getSymptomTypeName(), st2.getSymptomTypeName(), LinkTypeEnum.SymptomTypeToSymptomType.toString()));
            }
        }

//        HashMap<String, Object> map = new HashMap<String, Object>();
//        map.put("nodes", nodeList);
//        map.put("links", linkList);
//        map.put("totalGroup", totalGroup);

        return createGraphMap(nodeList, linkList, totalGroup);
    }

    public HashMap<String, Object> buildSymptomTypeGraph(String name) throws NullPointerException {
        SymptomType symptomType = symptomTypeDao.findSymptomTypeByName(name);
        if (symptomType == null)
            throw new NullPointerException("The symptomType node can't be found. ");
        List<String> idList = antibioticDao.findAllNodeID(symptomType.getSymptomTypeId());
        if (idList.size() == 0)
            return createSingleNodeGraphMap(symptomType.symptomType2GNode(NodeTypeEnum.SourceNode.ordinal()));

        List<SymptomType> symptomTypeList = symptomTypeDao.findSymptomTypeByIdList(idList);
        List<Symptom> symptomList = symptomDao.findSymptomByIdList(idList);

        List<GNode> nodeList = new ArrayList<GNode>();
        List<GLink> linkList = new ArrayList<GLink>();
        int totalGroup = 3;

        GNode sourceNode = symptomType.symptomType2GNode(NodeTypeEnum.SourceNode.ordinal());
        nodeList.add(sourceNode);
        for (SymptomType st : symptomTypeList
                ) {
            GNode node = st.symptomType2GNode(NodeTypeEnum.SymptomTypeNode.ordinal());
            nodeList.add(node);
            linkList.add(new GLink(sourceNode.getId(), node.getId(), LinkTypeEnum.SymptomTypeToSymptomType.toString()));
        }

        for (Symptom s : symptomList
                ) {
            GNode node = s.symptom2GNode(NodeTypeEnum.SymptomNode.ordinal());
            nodeList.add(node);
            linkList.add(new GLink(sourceNode.getId(), node.getId(), LinkTypeEnum.SymptomToSymptomType.toString()));
        }

        return createGraphMap(nodeList, linkList, totalGroup);
    }

    public HashMap<String, Object> buildComplicationGraph(String name) throws NullPointerException {
        Complication complication = complicationDao.findComplicationByName(name);
        if (complication == null)
            throw new NullPointerException("The complication node can't be found. ");

        List<String> idList = antibioticDao.findAllNodeID(complication.getComplicationId());
        if (idList.size() == 0)
            return createSingleNodeGraphMap(complication.complication2GNode(NodeTypeEnum.SourceNode.ordinal()));

        List<Disease> diseaseList = diseaseDao.findDiseaseByIdList(idList);

        List<GNode> nodeList = new ArrayList<GNode>();
        List<GLink> linkList = new ArrayList<GLink>();
        int totalGroup = 2;

        GNode sourceNode = complication.complication2GNode(NodeTypeEnum.SourceNode.ordinal());
        nodeList.add(sourceNode);
        for (Disease d : diseaseList
                ) {
            GNode node = d.disease2GNode(NodeTypeEnum.DiseaseNode.ordinal());
            nodeList.add(node);
            linkList.add(new GLink(sourceNode.getId(), node.getId(), LinkTypeEnum.DiseaseToComplication.toString()));
        }

        return createGraphMap(nodeList, linkList, totalGroup);
    }

    public HashMap<String, Object> buildInfectionSiteGraph(String name) throws NullPointerException {
        InfectionSite infectionSite = infectionSiteDao.findInfectionSiteByName(name);
        if (infectionSite == null)
            throw new NullPointerException("The infection site node can't be found. ");

        List<String> idList = antibioticDao.findAllNodeID(infectionSite.getInfectionSiteId());
        if (idList.size() == 0)
            return createSingleNodeGraphMap(infectionSite.infectionSite2GNode(NodeTypeEnum.SourceNode.ordinal()));

        List<Bacteria> bacteriaList = bacteriaDao.findBacteriaByID(idList);

        List<GNode> nodeList = new ArrayList<GNode>();
        List<GLink> linkList = new ArrayList<GLink>();
        int totalGroup = 2;

        GNode sourceNode = infectionSite.infectionSite2GNode(NodeTypeEnum.SourceNode.ordinal());
        nodeList.add(sourceNode);
        for (Bacteria b : bacteriaList
                ) {
            GNode node = b.bacteria2GNode(NodeTypeEnum.BacteriaNode.ordinal());
            nodeList.add(node);
            linkList.add(new GLink(sourceNode.getId(), node.getId(), LinkTypeEnum.BacteriaToInfectionSite.toString()));
        }

        return createGraphMap(nodeList, linkList, totalGroup);
    }


    public HashMap<String, Object> buildSituationGraph(String name) throws NullPointerException {
        Situation situation = situationDao.findSituationByName(name);
        if (situation == null)
            throw new NullPointerException("The situation node can't be found. ");

        List<String> idList = antibioticDao.findAllNodeID(situation.getSituationId());
        if (idList.size() == 0)
            return createSingleNodeGraphMap(situation.situation2GNode(NodeTypeEnum.SourceNode.ordinal()));

        List<Antibiotic> antibioticList = antibioticDao.findAntibioticByID(situation.getSituationId(), idList);

        List<GNode> nodeList = new ArrayList<GNode>();
        List<GLink> linkList = new ArrayList<GLink>();
        int totalGroup = 2;

        GNode sourceNode = situation.situation2GNode(NodeTypeEnum.SourceNode.ordinal());
        nodeList.add(sourceNode);
        for (Antibiotic a : antibioticList
                ) {
            GNode node = a.antibiotic2GNode(NodeTypeEnum.AntibioticNode.ordinal());
            nodeList.add(node);
            linkList.add(new GLink(sourceNode.getId(), node.getId(), LinkTypeEnum.AntibioticToSituation.toString()));
        }


        return createGraphMap(nodeList, linkList, totalGroup);
    }


    public HashMap<String, Object> findDBName(String name) throws NullPointerException {
        List<Integer> indexList = antibioticDao.findDBNameByKeyword(name);
        if (indexList == null)
            throw new NullPointerException("The type of the node can't be found. ");

        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("totalResult", 1);
        map.put("graph", indexMapToDBName(indexList.get(0)));
        return map;
    }

    public List<String> findAllantibioticName() {
        List<String> antibioticList = antibioticDao.findAllAntibioticName();
        return antibioticList;
    }

    public List<String> findAllbacteriaName() {
        List<String> bacteriaList = bacteriaDao.findAllBacteriaName();
        return bacteriaList;
    }

    public List<String> findAllcomplicationName() {
        List<String> complicationList = complicationDao.findAllComplicationName();
        return complicationList;
    }

    public List<String> findAlldiseaseName() {
        List<String> diseaseList = diseaseDao.findAllDiseaseName();
        return diseaseList;
    }

    public List<String> findAllinfectionSiteName() {
        List<String> infectionSiteList = infectionSiteDao.findAllInfectionSiteName();
        return infectionSiteList;
    }

    public List<String> findAllsituationName() {
        List<String> situationList = situationDao.findAllSituationName();
        return situationList;
    }

    public List<String> findAllsymptomName() {
        List<String> symptomList = symptomDao.findAllSymptomName();
        return symptomList;
    }

    public List<String> findAllsymptomTypeName() {
        List<String> symptomTypeList = symptomDao.findAllSymptomName();
        return symptomTypeList;
    }


    static private String indexMapToDBName(int i) {
        switch (i) {
            case 1:
                return "antibiotic";
            case 2:
                return "bacteria";
            case 3:
                return "complication";
            case 4:
                return "disease";
            case 5:
                return "infection_site";
            case 6:
                return "situation";
            case 7:
                return "symptom";
            case 8:
                return "symptom_type";
            default:
                return "";
        }
    }
}


