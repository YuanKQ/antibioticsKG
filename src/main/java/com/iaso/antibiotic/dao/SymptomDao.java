/******************************
 * User: yuan
 * Date: 17-7-11 下午9:02
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package com.iaso.antibiotic.dao;

import com.iaso.antibiotic.model.Symptom;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

//@Component
public class SymptomDao {
    private SqlSessionFactory sessionFactory;
    private SqlSession session;

    public SymptomDao() {
        String resource = "MyBatis-conf.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Symptom> findSymptomByIdList(List idList) {
        String statememt = "SymptomMapper.findSymptomByIdList";
        List<Symptom> symptomList = session.selectList(statememt, idList);

        return symptomList;
    }

    public Symptom findSymptomByName(String name) {
        String statement = "SymptomMapper.findSymptomByName";
        HashMap<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("name", name);
        paraMap.put("limit", 1);
        Symptom symptom = (Symptom) session.selectOne(statement, paraMap);

        return symptom;
    }
    public List<String> findAllSymptomName() {
        String statement = "SymptomMapper.findAllSymptomName";
        List<String> symptomList = session.selectList(statement);
        return symptomList;
    }
}
