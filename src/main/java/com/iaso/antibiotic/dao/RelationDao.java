/******************************
 * User: yuan
 * Date: 17-10-11 下午3:45
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package com.iaso.antibiotic.dao;

import com.iaso.antibiotic.model.KGRelation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class RelationDao {
    private SqlSessionFactory sessionFactory;
    private SqlSession session;

    public RelationDao() {
        String resource = "MyBatis-conf.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public KGRelation findRelationNameById(String relation_id) {
        String statement = "RelationMapper.findRelationNameById";
        return (KGRelation)session.selectOne(statement, relation_id);
    }
}
