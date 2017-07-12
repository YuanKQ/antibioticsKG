/******************************
 * User: yuan
 * Date: 17-7-11 下午4:30
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package com.iaso.antibiotic.dao;

import com.iaso.antibiotic.model.Disease;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

//@Component
public class DiseaseDao {
    private SqlSession session;
    private SqlSessionFactory sessionFactory;

    public DiseaseDao() {
        String resource = "MyBatis-conf.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Disease> findDiseaseByIdList(List<String> idList) {
        String statememt = "DiseaseMapper.findDiseaseByIdList";
        List<Disease> diseaseList = session.selectList(statememt, idList);

        return diseaseList;
    }

    public Disease findDiseaseByName(String name) {
        String statememt = "DiseaseMapper.findDiseaseByName";
        HashMap<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("name", name);
        paraMap.put("limit", 1);
        Disease disease = (Disease) session.selectOne(statememt, paraMap);

        return disease;
    }
}
