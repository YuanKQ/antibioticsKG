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
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface RelationDao {

    KGRelation findRelationNameById(@Param("relation_id") String relation_id);
}
