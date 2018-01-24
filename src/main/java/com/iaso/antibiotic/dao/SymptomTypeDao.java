/******************************
 * User: yuan
 * Date: 17-7-12 下午4:53
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package com.iaso.antibiotic.dao;

import com.iaso.antibiotic.model.SymptomType;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.w3c.dom.ls.LSException;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Component
public class SymptomTypeDao {
    private SqlSessionFactory sessionFactory;
    private SqlSession session;

    public SymptomTypeDao() {
        String resource = "MyBatis-conf.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<SymptomType> findSymptomTypeByIdList(List<String> idList) {
        String statememt = "SymptomTypeMapper.findSymptomTypeByIdList";
        List<SymptomType> symptomTypeList = session.selectList(statememt, idList);

        return symptomTypeList;
    }

    public SymptomType findSymptomTypeByName(String name) {
        String statememt = "SymptomTypeMapper.findSymptomTypeByName";
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("name", name);
        paraMap.put("limit", 1);
        SymptomType symptomType = (SymptomType) session.selectOne(statememt, paraMap);

        return symptomType;
    }
    public List<String> findAllSymptomTypeName() {
        String statement = "symptomTypeMapper.findAllsymptomTypeName";
        List<String> symptomTypeList = session.selectList(statement);
        return symptomTypeList;
    }
}

