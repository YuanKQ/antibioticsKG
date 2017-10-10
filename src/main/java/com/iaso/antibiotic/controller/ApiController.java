/******************************
 * User: yuan
 * Date: 17-10-6 上午11:24
 * Email: kq_yuan@outlook.com
 *
 * Description: Api调用功能
 *
 *             实体: [单个查询] GET /api/{antibiotic, bacteria, complication, disease, infection-sit, situation, symptom, symptom-type}/$name
 *                  [批量查询] 待续~
 *
 *             关系: [单个查询] GET /api/relation/$name1/$name2, /api/relation/$id1/$id2
 *                  [批量查询] 待续~
 *
 *             子图: [单个查询] GET /api/subgraph/$name1, /api/subgraph/$id1
 *
 *             FOR EXPERIMENT: POST 更新testTable
 *
 ******************************/
package com.iaso.antibiotic.controller;

import com.iaso.antibiotic.json.DataNode;
import com.iaso.antibiotic.json.GNode;
import com.iaso.antibiotic.model.Antibiotic;
import com.iaso.antibiotic.service.AntibioticService;
import com.iaso.antibiotic.service.ApiService;
import org.springframework.web.bind.annotation.*;
import com.iaso.antibiotic.exception.NoSuchConceptException;

@RestController
@RequestMapping("/api")
public class ApiController {
    /* //TEST: SpringMVC RequestMapping for both class and methods
    @RequestMapping(value="/tutorial", method = RequestMethod.GET)
    @ResponseBody
    public String tutorialPage() {
        return "api-tutorial";
    }
    */

    // 用static?
    private ApiService apiService = new ApiService();

    @RequestMapping(value= "/{entityType}/{name}", method = RequestMethod.GET)
    public DataNode antibioticSingleNode(@PathVariable String entityType, @PathVariable String name) {
        try {
            return apiService.getSingleNode(entityType, name);
        } catch (NullPointerException e) {
            return new DataNode(1, String.format("NullPointerException: %s can't be found in the KG.", name), null);
        } catch (NoSuchConceptException e) {
            return new DataNode(2, String.format("NoSuchConceptException: %s can't be found in the KG.", entityType), null);
        }
    }
}
