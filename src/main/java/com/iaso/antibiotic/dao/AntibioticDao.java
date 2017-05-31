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
import com.iaso.antibiotic.model.Bacteria;
import com.iaso.antibiotic.model.Situation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import javax.annotation.Resources;

public class AntibioticDao {
    private SqlSessionFactory sessionFactory;
    private SqlSession session;

    public AntibioticDao() {
        String resource = "MyBatis-conf.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Antibiotic findAntibioticByName(String name) {
        String statement = "AntibioticMapper.findAntibioticByName";
        Antibiotic antibiotic = (Antibiotic)session.selectOne(statement, name);
        return antibiotic;
    }
    public List<Antibiotic> findAntibioticByID(String id, List<String> idList){
        String statment = "AntibioticMapper.findAntibioticByID";
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("id", id);
        paraMap.put("list", idList);
        List<Antibiotic> antibioticList = session.selectList(statment, paraMap);
        return antibioticList;
    }

    public List<String> findAllNodeID(String id){
        String statment = "AntibioticMapper.findAllNodeID";
        List<String> idList = session.selectList(statment, id);
        return idList;
    }

    public List<Bacteria> findBacteriaByID(List<String> idList){
        String statment = "AntibioticMapper.findBacteriaByID";
        List<Bacteria> bacteriaList = session.selectList(statment, idList);
        return bacteriaList;
    }

    public List<Situation> findSituationByID(List<String> idList){
        String statment = "AntibioticMapper.findSituationByID";
        List<Situation> situationList = session.selectList(statment, idList);
        return situationList;
    }
}