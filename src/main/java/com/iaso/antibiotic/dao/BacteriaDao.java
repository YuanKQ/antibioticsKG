/******************************
 * User: yuan
 * Date: 17-7-9 下午4:23
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package com.iaso.antibiotic.dao;

import com.iaso.antibiotic.model.Bacteria;
import org.apache.ibatis.annotations.Mapper;
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

@Component
@Mapper
public interface BacteriaDao {

    Bacteria findBacteriaByName(String name);

    public List<Bacteria> findBacteriaByID(List<String> idList);

    public List<String> findAllBacteriaName();
}
