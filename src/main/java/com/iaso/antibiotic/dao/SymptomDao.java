/******************************
 * User: yuan
 * Date: 17-7-11 下午9:02
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package com.iaso.antibiotic.dao;

import com.iaso.antibiotic.model.Symptom;
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

@Component
@Mapper
public interface SymptomDao {

    public List<Symptom> findSymptomByIdList(List idList);

    public Symptom findSymptomByName(String name);

    public List<String> findAllSymptomName();
}
