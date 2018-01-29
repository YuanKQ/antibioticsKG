/******************************
 * User: yuan
 * Date: 17-5-24 下午9:15
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package com.iaso.antibiotic.dao;

import com.iaso.antibiotic.model.Antibiotic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

//import javax.annotation.Resources;

@Component
@Mapper
public interface AntibioticDao {
    Antibiotic findAntibioticByName(@Param("name") String name);

    List<String> findAllAntibioticName();

    String findAllrelationName();

    List<Antibiotic> findAntibioticByID(String id, List<String> ids);//TODO screen result

    List<String> findAllNodeID(@Param("researching_id") String researching_id);

    List<Integer> findDBNameByKeyword(@Param("name") String name);

    String findEdgeByNodeIds(@Param("head") String head, @Param("tail") String tail);


//    public List<Antibiotic> findAll(List<String> idList){
//        String statment = "AntibioticMapper.findAntibioticByID";
//        Map<String, Object> paraMap = new HashMap<String, Object>();
//        paraMap.put("list", idList);
//        List<Antibiotic> antibioticList = session.selectList(statment, paraMap);
//        for (Antibiotic a : antibioticList
//                ) {
//            if (a.getId().equals(id)) {
//                antibioticList.remove(a);
//                break;
//            }
//        }
//        return antibioticList;
//    }

//    public Antibiotic findAntibioticByName(String name) {
//        String statement = "AntibioticMapper.findAntibioticByName";
//        Map<String, Object> paraMap = new HashMap<String, Object>();
//        paraMap.put("name", name);
//        paraMap.put("limit", 1);
//        Antibiotic antibiotic = (Antibiotic) session.selectOne(statement, paraMap);
//        return antibiotic;
//    }
//
//    public String findEdgeByNodeIds(String headId, String tailId) {
//        String statement = "AntibioticMapper.findEdgeByNodeIds";
//        Map<String, Object> paraMap = new HashMap<String, Object>();
//        paraMap.put("head", headId);
//        paraMap.put("tail", tailId);
//        return (String) session.selectOne(statement, paraMap);
//    }
//
//    public List<Antibiotic> findAntibioticByID(String id, List<String> idList){
//        String statment = "AntibioticMapper.findAntibioticByID";
//        Map<String, Object> paraMap = new HashMap<String, Object>();
//        paraMap.put("list", idList);
//        List<Antibiotic> antibioticList = session.selectList(statment, paraMap);
//        for (Antibiotic a : antibioticList
//                ) {
//            if (a.getId().equals(id)) {
//                antibioticList.remove(a);
//                break;
//            }
//        }
//        return antibioticList;
//    }
//
//    public List<String> findAllNodeID(String id){
//        String statment = "AntibioticMapper.findAllNodeID";
//        List<String> idList = session.selectList(statment, id);
//        return idList;
//    }
//
//    public List<Integer> findDBNameByKeyword(String name) {
//        String statement = "AntibioticMapper.findDBNameByKeyword";
//        List<Integer> dbNoList = session.selectList(statement, name);
//
//        return dbNoList;
//    }
//
//    public String findRelationNameById(String relation_id) {
//        String statement = "AntibioticMapper.findRelationNameById";
//        return (String) session.selectOne(statement, relation_id);
//    }
//
///*    public List<Bacteria> findBacteriaByID(List<String> idList){
//        String statment = "BacteriaMapper.findBacteriaByID";
//        List<Bacteria> bacteriaList = session.selectList(statment, idList);
//        return bacteriaList;
//    }*/
//
//    /*public List<Situation> findSituationByID(List<String> idList){
//        String statment = "SituationMapper.findSituationByID";
//        List<Situation> situationList = session.selectList(statment, idList);
//        return situationList;
//    }*/
//
//    public List<String> findAllAntibioticName() {
//        String statement = "AntibioticMapper.findAllAntibioticName";
//        List<String> antibioticList = session.selectList(statement);
//        return antibioticList;
//    }

}
