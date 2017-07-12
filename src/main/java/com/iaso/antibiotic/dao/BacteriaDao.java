/******************************
 * User: yuan
 * Date: 17-7-9 下午4:23
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package com.iaso.antibiotic.dao;

import com.iaso.antibiotic.model.Antibiotic;
import com.iaso.antibiotic.model.Bacteria;
import com.iaso.antibiotic.model.InfectionSite;
import com.iaso.antibiotic.model.Situation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Component
public class BacteriaDao {
    private SqlSession session;
    private SqlSessionFactory sessionFactory;

    public BacteriaDao() {
        String resource = "MyBatis-conf.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Bacteria findBacteriaByName(String name) {
        String statement = "BacteriaMapper.findBacteriaByName";
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("name", name);
        paraMap.put("limit", 1);
        Bacteria bacteria = (Bacteria) session.selectOne(statement, paraMap);

        return bacteria;
    }

    public List<Bacteria> findBacteriaByID(List<String> idList) {
        String statment = "BacteriaMapper.findBacteriaByID";
        List<Bacteria> bacteriaList = session.selectList(statment, idList);
        return bacteriaList;
    }

}
