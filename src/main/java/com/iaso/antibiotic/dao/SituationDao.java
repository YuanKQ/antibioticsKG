/******************************
 * User: yuan
 * Date: 17-7-11 下午4:23
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package com.iaso.antibiotic.dao;

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

//@Component
public class SituationDao {

    private SqlSession session;
    private SqlSessionFactory sessionFactory;

    public SituationDao() {
        String resource = "MyBatis-conf.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Situation> findSituationByID(List<String> idList) {
        String statment = "SituationMapper.findSituationByID";
        List<Situation> situationList = session.selectList(statment, idList);
        return situationList;
    }

    public Situation findSituationByName(String name) {
        String statememt = "SituationMapper.findSituationByName";
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("name", name);
        paraMap.put("limit", 1);
        Situation situation = (Situation) session.selectOne(statememt, paraMap);

        return situation;
    }
    public List<String> findAllSituationName() {
        String statement = "SituationMapper.findAllSituationName";
        List<String> situationList = session.selectList(statement);
        return situationList;
    }
}
