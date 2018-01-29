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
import org.apache.ibatis.annotations.Mapper;
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

@Component
@Mapper
public interface SymptomTypeDao {

    public List<SymptomType> findSymptomTypeByIdList(List<String> idList);

    public SymptomType findSymptomTypeByName(String name);

    public List<String> findAllSymptomTypeName();
}

