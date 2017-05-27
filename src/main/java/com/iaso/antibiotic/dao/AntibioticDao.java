/******************************
 * User: yuan
 * Date: 17-5-24 下午9:15
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package com.iaso.antibiotic.dao;

import com.iaso.antibiotic.model.Antibiotic;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

//import javax.annotation.Resources;

public class AntibioticDao {
    private SqlSessionFactory sessionFactory;
    private SqlSession session;

    public AntibioticDao() {
        String resource = "MyBatis-conf.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Antibiotic findAntibioticByName(String name) {
        String statement = "AntibioticMapper.findAntibioticByName";
        Antibiotic antibiotic = (Antibiotic)session.selectOne(statement, name);
        return antibiotic;
    }
}
