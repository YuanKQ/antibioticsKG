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
import java.util.List;

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
}

