/******************************
 * User: yuan
 * Date: 17-7-9 下午5:23
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package com.iaso.antibiotic.dao;

import com.iaso.antibiotic.model.InfectionSite;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface InfectionSiteDao {

    public List<InfectionSite> findInfectionSiteByID(List<String> idList) ;

    public InfectionSite findInfectionSiteByName(String name);

    public List<String> findAllInfectionSiteName();
}
