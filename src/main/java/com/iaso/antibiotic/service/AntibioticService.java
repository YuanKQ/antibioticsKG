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
import com.iaso.antibiotic.model.SymptomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sun.nio.fs.GnomeFileTypeDetector;

import javax.xml.ws.ServiceMode;
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

public class AntibioticService {

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

//    public AntibioticService() {
//        antibioticDao = new AntibioticDao();
//    }
//
//
//    public Antibiotic findAntibioticByName(String name){
//        return antibioticDao.findAntibioticByName(name);
//    }
//
//    public List<String> findAllNodeID(String id){
//        return antibioticDao.findAllNodeID(id);
//    }
//
//    public List<Bacteria> findBcateriaByID(List<String> idList){
//        return antibioticDao.findBacteriaByID(idList);
//    }
//
//    public List<Situation> findSituationByID(List<String> idList){
//        return antibioticDao.findSituationByID(idList);
//    }
//
//    public List<Antibiotic> findAntibioticByID(String id, List<String> idList){
//        return antibioticDao.findAntibioticByID(id, idList);
//    }

    private HashMap<String, Object> createGraphMap(List<GNode> nodeList, List<GLink> linkList, int max) {
//        List<GLink> linkList = new ArrayList<GLink>();
//        int size = nodeList.size();
//        int max = 0;
//        for (int i = 1; i < size; i++) {
//            int tmp = nodeList.get(i).getGroup();
//            max = max > tmp ? max : tmp;
//            GLink link = new GLink(nodeList.get(0).getId(), nodeList.get(i).getId(), tmp);
//            linkList.add(link);
//        }

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("nodes", nodeList);
        map.put("links", linkList);
        map.put("totalGroup", max);

        return map;
    }

    public HashMap<String, Object> buildBacteriaGraph(String name) {
        Bacteria bacteria = bacteriaDao.findBacteriaByName(name);
        List<String> idList = antibioticDao.findAllNodeID(bacteria.getBacteriaId());
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

    public HashMap<String, Object> buildAntibioticGraph(String name) {
        Antibiotic antibiotic = antibioticDao.findAntibioticByName(name);
        List<String> idList = antibioticDao.findAllNodeID(antibiotic.getId());
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

    public HashMap<String, Object> buildDiseaseGraph(String name) {
        Disease disease = diseaseDao.findDiseaseByName(name);
        List<String> idList = antibioticDao.findAllNodeID(disease.getId());
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

    public HashMap<String, Object> buildSymptomGraph(String name) {
        Symptom symptom = symptomDao.findSymptomByName(name);
        List<String> idList = antibioticDao.findAllNodeID(symptom.getSymptomId());
        if (idList.isEmpty())
            return null;

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

}


