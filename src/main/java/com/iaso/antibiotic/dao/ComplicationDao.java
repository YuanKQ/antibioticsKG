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
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

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
}
