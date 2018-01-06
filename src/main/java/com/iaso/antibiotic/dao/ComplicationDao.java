/******************************
 * User: yuan
 * Date: 17-7-11 下午8:51
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package com.iaso.antibiotic.dao;

import com.iaso.antibiotic.model.Complication;
import com.iaso.antibiotic.model.Disease;
import com.iaso.antibiotic.model.SymptomType;
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
public class ComplicationDao {
    private SqlSession session;
    private SqlSessionFactory sessionFactory;

    public ComplicationDao() {
        String resource = "MyBatis-conf.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Complication> findComplicationByIdList(List<String> idList) {
        String statememt = "ComplicationMapper.findComplicationByIdList";
        List<Complication> complicationList = session.selectList(statememt, idList);

        return complicationList;
    }

    public Complication findComplicationByName(String name) {
        String statememt = "ComplicationMapper.findComplicationByName";
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("name", name);
        paraMap.put("limit", 1);
        Complication complication = (Complication) session.selectOne(statememt, paraMap);

        return complication;
    }
    public List<String> findAllComplicationName() {
        String statement = "ComplicationMapper.findAllComplicationName";
        List<String> ComplicationList = session.selectList(statement);
        return ComplicationList;
    }
}
