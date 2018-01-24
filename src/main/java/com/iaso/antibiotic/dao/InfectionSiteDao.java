/******************************
 * User: yuan
 * Date: 17-7-9 下午5:23
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package com.iaso.antibiotic.dao;

import com.iaso.antibiotic.model.Complication;
import com.iaso.antibiotic.model.InfectionSite;
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
public class InfectionSiteDao {
    private SqlSession session;
    private SqlSessionFactory sessionFactory;

    public InfectionSiteDao() {
        String resource = "MyBatis-conf.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<InfectionSite> findInfectionSiteByID(List<String> idList) {
        String statement = "InfectionSiteMapper.findInfectionSiteByID";
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("list", idList);
        List<InfectionSite> infectionSiteList = session.selectList(statement, paraMap);

        return infectionSiteList;
    }

    public InfectionSite findInfectionSiteByName(String name) {
        String statememt = "InfectionSiteMapper.findInfectionSiteByName";
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("name", name);
        paraMap.put("limit", 1);
        InfectionSite infectionSite = (InfectionSite) session.selectOne(statememt, paraMap);
        return infectionSite;
    }
    public List<String> findAllInfectionSiteName() {
        String statement = "InfectionSiteMapper.findAllInfectionSiteName";
        List<String> InfectionSiteList = session.selectList(statement);
        return InfectionSiteList;
    }
}
