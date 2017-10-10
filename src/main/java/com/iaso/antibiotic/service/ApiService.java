/******************************
 * User: yuan
 * Date: 17-10-10 下午4:14
 * Email: kq_yuan@outlook.com
 *
 * Description: 为API调用而写的持久层服务
 *
 ******************************/
package com.iaso.antibiotic.service;

import com.iaso.antibiotic.dao.*;
import com.iaso.antibiotic.exception.NoSuchConceptException;
import com.iaso.antibiotic.json.DataNode;
import com.iaso.antibiotic.model.Antibiotic;

public class ApiService {
    //@Autowired
    private AntibioticDao antibioticDao = new AntibioticDao();

    //    @Autowired
    private BacteriaDao bacteriaDao = new BacteriaDao();

    //    @Autowired
    private SituationDao situationDao = new SituationDao();

    //    @Autowired
    private InfectionSiteDao infectionSiteDao = new InfectionSiteDao();

    //    @Autowired
    private DiseaseDao diseaseDao = new DiseaseDao();

    //    @Autowired
    private ComplicationDao complicationDao = new ComplicationDao();

    //    @Autowired
    private SymptomDao symptomDao = new SymptomDao();

    //    @Autowired
    private SymptomTypeDao symptomTypeDao = new SymptomTypeDao();

    public DataNode getSingleNode(String dbName, String name) throws NullPointerException, NoSuchConceptException {
        Object data = null;
        if (dbName.equals("antibiotic")) {
            data = antibioticDao.findAntibioticByName(name);
        } else if (dbName.equals("bacteria")) {
            data = bacteriaDao.findBacteriaByName(name);
        } else if (dbName.equals("disease")) {
            data = diseaseDao.findDiseaseByName(name);
        } else if (dbName.equals("symptom")) {
            data = symptomDao.findSymptomByName(name);
        } else if (dbName.equals("infection_site")) {
            data = infectionSiteDao.findInfectionSiteByName(name);
        } else if (dbName.equals("symptom_type")) {
            data = symptomTypeDao.findSymptomTypeByName(name);
        } else if (dbName.equals("complication")) {
            data = complicationDao.findComplicationByName(name);
        } else if (dbName.equals("situation")) {
            data = situationDao.findSituationByName(name);
        } else {
            throw new NoSuchConceptException();
        }

        if (data == null)
            throw new NullPointerException();

        return new DataNode(0, "success", data);
    }



}