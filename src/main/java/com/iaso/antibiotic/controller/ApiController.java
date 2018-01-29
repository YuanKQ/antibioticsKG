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
 *             关系: [单个查询] GET /api/KGRelation/$name1/$name2, /api/KGRelation/$id1/$id2
 *                  [批量查询] 待续~
 *
 *             子图: [单个查询] GET /api/subgraph/$name1, /api/subgraph/$id1
 *
 *             FOR EXPERIMENT: POST 更新Table: TEST_RESTful
 *
 ******************************/
package com.iaso.antibiotic.controller;

import com.iaso.antibiotic.exception.DuplicateResourceException;
import com.iaso.antibiotic.json.*;
import com.iaso.antibiotic.model.TESTRestful;
import com.iaso.antibiotic.service.ApiService;
import com.iaso.antibiotic.service.TESTService;
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
//    private ApiService apiService = new ApiService();
//    private TESTService testService = new TESTService();

    private ApiService apiService = null;
    private TESTService testService = null;

    // 调试完成后统一加上 catch (Exception e) {
    @RequestMapping(value= "/{entityType}/{name}", method = RequestMethod.GET)
    public DataNode getSingleNode(@PathVariable String entityType, @PathVariable String name) {
        try {
            return apiService.getSingleNode(entityType, name);
        } catch (NullPointerException e) {
            return new DataNode(1, String.format("NullPointerException: %s can't be found in the KG.", name),
                                null);
        } catch (NoSuchConceptException e) {
            return new DataNode(2,
                                 String.format("NoSuchConceptException: %s can't be found in the KG.", entityType),
                                null);
        } catch (Exception e) {
            String msg = "";
            StackTraceElement[] stackTraceElements = e.getStackTrace();
            for (StackTraceElement s: stackTraceElements) {
                msg += s;
            }
            return new DataNode(100, msg, null);
        }
    }

    @RequestMapping(value = "/relations/{head}/{tail}", method = RequestMethod.GET)
    public DataLink getSingleLink(@PathVariable String head, @PathVariable String tail) {
        try {
            return apiService.getSingleLink(head, tail);
        } catch (NullPointerException e) {
            return new DataLink(1,
                                 String.format("NullPointerException: %s can't be found in the KG.", e.getMessage()));
        } catch (Exception e) {
            String msg = "";
            StackTraceElement[] stackTraceElements = e.getStackTrace();
            for (StackTraceElement s: stackTraceElements) {
                msg += s;
            }
            return new DataLink(100, msg);
        }
    }

    @RequestMapping(value = "/subgraphs/{center}", method = RequestMethod.GET)
    public DataSubgraph getSubgraph(@PathVariable String center) {
        try {
            return apiService.getSubgraph(center);
        } catch (NullPointerException e) {
            return new DataSubgraph(1,
                    String.format("NullPointerException: %s can't be found in the KG.", e.getMessage()));
        }
    }

    /*以下服务不对外开放, 仅用作测试*/
    /*以下的POST, PUT, DELETE服务并不会改变数据库,数据存储在内存中, 关闭服务之后数据即清空*/
    @RequestMapping(value = "/TEST", method = RequestMethod.POST)
    public DataTEST testPost(@RequestBody TESTRestful dataTest){
        System.out.println("Creating a new resource.");
        try {
            return testService.createResource(dataTest);
        } catch (DuplicateResourceException e) {
            return new DataTEST(101, String.format("DuplicateResourceException: %s already exist.",e.getMessage()));
        }
    }

    @RequestMapping(value = "/TEST", method = RequestMethod.PUT)
    public DataTEST testPut(@RequestBody TESTRestful testRestful) {
        System.out.println("Updating a existed resource.");
        try {
            return testService.updateResource(testRestful);
        } catch (NullPointerException e) {
            return new DataTEST(1, String.format("NullPointerException: %s can't be found.", testRestful.getName()));
        }
    }

    @RequestMapping(value = "/TEST/{id}", method = RequestMethod.DELETE)
    public DataTEST testDelete(@PathVariable("id") int id) {
        System.out.println("Deleting...");
        try {
            return testService.deleteResource(id);
        } catch (NullPointerException e) {
            return new DataTEST(1, String.format("NullPointerException: %d can't be found.", id));
        }
    }

}
