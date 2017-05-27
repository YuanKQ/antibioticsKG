/******************************
 * User: yuan
 * Date: 17-5-24 下午10:37
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package com.iaso.antibiotic.service;

import com.iaso.antibiotic.dao.AntibioticDao;
import com.iaso.antibiotic.model.Antibiotic;

public class AntibioticService {
    private AntibioticDao antibioticDao;

    public AntibioticService() {
        antibioticDao = new AntibioticDao();
    }

    public Antibiotic findAntibioticByName(String name){
        return antibioticDao.findAntibioticByName(name);
    }
}
