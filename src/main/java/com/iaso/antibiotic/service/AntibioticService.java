/******************************
 * User: yuan
 * Date: 17-5-24 下午10:37
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package com.iaso.antibiotic.service;

import com.iaso.antibiotic.dao.AntibioticDao;
import com.iaso.antibiotic.json.GLink;
import com.iaso.antibiotic.json.GNode;
import com.iaso.antibiotic.model.Antibiotic;
import com.iaso.antibiotic.model.Bacteria;
import com.iaso.antibiotic.model.Situation;
import sun.nio.fs.GnomeFileTypeDetector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AntibioticService {
    private AntibioticDao antibioticDao;

    public AntibioticService() {
        antibioticDao = new AntibioticDao();
    }

    public Antibiotic findAntibioticByName(String name){
        return antibioticDao.findAntibioticByName(name);
    }

    public List<String> findAllNodeID(String id){
        return antibioticDao.findAllNodeID(id);
    }

    public List<Bacteria> findBcateriaByID(List<String> idList){
        return antibioticDao.findBacteriaByID(idList);
    }

    public List<Situation> findSituationByID(List<String> idList){
        return antibioticDao.findSituationByID(idList);
    }

    public List<Antibiotic> findAntibioticByID(String id, List<String> idList){
        return antibioticDao.findAntibioticByID(id, idList);
    }

    public HashMap<String, Object> buildAntibioticGraph(String name) {
        Antibiotic antibiotic = findAntibioticByName(name);
        List<String> idList = findAllNodeID(antibiotic.getId());
        List<Bacteria> bacteriaList = findBcateriaByID(idList);
        List<Situation> situationList = findSituationByID(idList);
        List<Antibiotic> antibioticList = findAntibioticByID(antibiotic.getId(), idList);

        List<GNode> nodeList = new ArrayList<GNode>();
        GNode sourceNode = antibiotic.antibiotic2GNode(0);
        nodeList.add(sourceNode);
        for (Antibiotic a : antibioticList) {
            GNode node = a.antibiotic2GNode(1);
            nodeList.add(node);
        }

        for (Bacteria b : bacteriaList) {
            GNode node = b.bacteria2GNode(2);
            nodeList.add(node);
        }

        for (Situation s : situationList
                ) {
            GNode node = s.situation2GNode(3);
            nodeList.add(node);
        }

        List<GLink> linkList = new ArrayList<GLink>();
        int size = nodeList.size();
        int max = 0;
        for (int i = 1; i < size; i++) {
            int tmp = nodeList.get(i).getGroup();
            max = max > tmp ? max : tmp;
            GLink link = new GLink(nodeList.get(0).getId(), nodeList.get(i).getId(), tmp);
            linkList.add(link);
        }

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("nodes", nodeList);
        map.put("links", linkList);
        map.put("totalGroup", max);

        return map;
    }
}
