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
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ComplicationDao {

    List<Complication> findComplicationByIdList(List<String> idList);

    Complication findComplicationByName(String name);

    List<String> findAllComplicationName();
}
