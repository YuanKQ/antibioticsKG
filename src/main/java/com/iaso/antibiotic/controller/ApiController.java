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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class ApiController {

    @RequestMapping(value="/tutorial", method = RequestMethod.GET)
    @ResponseBody
    public String tutorialPage() {
        return "api-tutorial";
    }

    @RequestMapping(value= "/antibiotic/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String antibioticSingleNode(@PathVariable String name) {
        return "singleNode: " + name;
    }
}
