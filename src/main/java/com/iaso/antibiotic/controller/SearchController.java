package com.iaso.antibiotic.controller;

import com.iaso.antibiotic.service.AntibioticService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;


/**
 * Created by yuan on 17-5-10.
 */

@Controller
public class SearchController {
    //  搜索栏:搜索领域graph，搜索关键词keywords
//    private AntibioticService antibioticService = new AntibioticService();
//    @RequestMapping(value = "/tree", method = RequestMethod.GET)
//    public @ResponseBody List<String> Name(){
//        List<String> antibioticnames = antibioticService.findAllantibioticName();
//        return antibioticnames;
//    }

    @Autowired
    private AntibioticService antibioticService ;

//    @RequestMapping(value = "/tree", method = RequestMethod.GET)
//    public @ResponseBody JSONObject Name() {
//        HashMap<String, Object> map = new HashMap<String, Object>();
//        map.put("antibioticnames", antibioticService.findAllantibioticName());
//        map.put("bacterianames",antibioticService.findAllbacteriaName());
//        map.put("complicationnames",antibioticService.findAllcomplicationName());
//        map.put("diseasenames",antibioticService.findAlldiseaseName());
//        map.put("infectionSitenames",antibioticService.findAllinfectionSiteName());
//        map.put("situationnames",antibioticService.findAllsituationName());
//        map.put("symptomnames",antibioticService.findAllsymptomName());
//        map.put("symptomTypenames",antibioticService.findAllsymptomTypeName());
//        JSONObject obj = JSONObject.fromObject(map);
//        return obj;
//    }

    @RequestMapping(value = "/tree", method = RequestMethod.GET)
    public @ResponseBody HashMap<String, Object> Name() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("antibioticnames", antibioticService.findAllantibioticName());
        map.put("bacterianames",antibioticService.findAllbacteriaName());
        map.put("complicationnames",antibioticService.findAllcomplicationName());
        map.put("diseasenames",antibioticService.findAlldiseaseName());
        map.put("infectionSitenames",antibioticService.findAllinfectionSiteName());
        map.put("situationnames",antibioticService.findAllsituationName());
        map.put("symptomnames",antibioticService.findAllsymptomName());
        map.put("symptomTypenames",antibioticService.findAllsymptomTypeName());

//        JSONObject obj = JSONObject.fromObject(map);
        return map;
    }

    @RequestMapping(name = "/**/search", method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String, Object> search(String keywords, String graph) {
        try {
            if (graph.equals("antibioticKG")) {
                HashMap<String, Object> map = antibioticService.findDBName(keywords);

                if (map.get("totalResult").equals(1))
                    graph = (String) map.get("graph");
                else throw new NullPointerException("Duplicate name.");
            }

            if (graph.equals("antibiotic")) {
                return antibioticService.buildAntibioticGraph(keywords);
            } else if (graph.equals("bacteria")) {
                return antibioticService.buildBacteriaGraph(keywords);
            } else if (graph.equals("disease")) {
                return antibioticService.buildDiseaseGraph(keywords);
            } else if (graph.equals("symptom")) {
                return antibioticService.buildSymptomGraph(keywords);
            } else if (graph.equals("infection_site")) {
                return antibioticService.buildInfectionSiteGraph(keywords);
            } else if (graph.equals("symptom_type")) {
                return antibioticService.buildSymptomTypeGraph(keywords);
            } else if (graph.equals("complication")) {
                return antibioticService.buildComplicationGraph(keywords);
            } else if (graph.equals("situation")) {
                return antibioticService.buildSituationGraph(keywords);
            } else {
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("status", 404);
                map.put("msg", "Graph doesn't exist.");
                return map;
            }
        } catch (NullPointerException e) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("status", 404);
            map.put("msg", e.getMessage());
            return map;
        }

        /*if (graph.equals("antibioticKG")) {
            HashMap<String, Object> map = antibioticService.findDBName(keywords);
        }

        if (graph.equals("antibiotic")) {
            return antibioticService.buildAntibioticGraph(keywords);
        } else if (graph.equals("bacteria")) {
            return antibioticService.buildBacteriaGraph(keywords);
        } else if (graph.equals("disease")) {
            return antibioticService.buildDiseaseGraph(keywords);
        } else if (graph.equals("symptom")) {
            return antibioticService.buildSymptomGraph(keywords);
        } else if (graph.equals("infection_site")) {
            return antibioticService.buildInfectionSiteGraph(keywords);
        } else if (graph.equals("symptom_type")) {
            return antibioticService.buildSymptomTypeGraph(keywords);
        } else if (graph.equals("complication")) {
            return antibioticService.buildComplicationGraph(keywords);
        } else if (graph.equals("situation")) {
            return antibioticService.buildSituationGraph(keywords);
        } else {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("keywords", keywords);
            map.put("totalResult", 0);
            map.put("status", 400);
            return map;
        }*/
    }
    /* // !!!推荐: parse 复杂对象(内含ArrayList<对象>) into json
    public HashMap<String, Object> testGraph(String keywords, String graph) {
        HashMap<String, Object> map = new HashMap<String, Object>();

        GNode gNode1 = new GNode("One", 1);
        GNode gNode2 = new GNode("Two", 2);
        GNode gNode = new GNode("Source", 0);
        ArrayList<GNode> node_list = new ArrayList<GNode>();
        node_list.add(gNode);
        node_list.add(gNode1);
        node_list.add(gNode2);
        map.put("nodes", node_list);

        GLink gLink1 = new GLink("Source", "One");
        GLink gLink2 = new GLink("Source", "Two");
        ArrayList<GLink> link_list = new ArrayList<GLink>();
        link_list.add(gLink1);
        link_list.add(gLink2);
        map.put("links", link_list);

        return map;
    }*/

    // parse 复杂对象(内含ArrayList<对象>) into json, 但是这种做法不符合POJO原则(对象套对象)
/*    public Graph testGraph(String keywords, String graph) {
        HashMap<String, Object> map = new HashMap<String, Object>();

        Graph test_graph = new Graph();

        GNode gNode1 = new GNode("One", 1);
        GNode gNode2 = new GNode("Two", 2);
        GNode gNode = new GNode("Source", 0);
        ArrayList<GNode> node_list = new ArrayList<GNode>();
        node_list.add(gNode);
        node_list.add(gNode1);
        node_list.add(gNode2);
        test_graph.setNodes(node_list);

        GLink gLink1 = new GLink("Source", "One");
        GLink gLink2 = new GLink("Source", "Two");
        ArrayList<GLink> link_list = new ArrayList<GLink>();
        link_list.add(gLink1);
        link_list.add(gLink2);
        test_graph.setLinks(link_list);

        return test_graph;
    }*/

   /* //简单版的parse 对象 into json
    public TestJson test(String keywords, String graph) {
        System.out.println("keywords:" + keywords + "\ngraph:" + graph);

        TestJson testJson = new TestJson(keywords,graph);
        return testJson;
    }*/


// 该方法不可行，重定向太多次了
// public String testRedirect(String keywords, String graph, RedirectAttributes attr) {
//        attr.addAttribute("keywords", keywords);
//        return "redirect:/" + graph + "/hello";
//    }


/*  public String getSearchText(String keywords, String graph, Model model) {
        System.out.println("get keywords from search bar: " + keywords);
//        model.addAttribute("test", keywords);
//        model.addAttribute("domain", graph);
//        return "test";
        return "redirect:/" + graph + "/hello";
    }

//以下两种方法与上述方法效果相同,此时注意search.html表单是以GET形式请求
    @RequestMapping(name="/search")
    public String getSearchText(String keywords, Model model) {
        System.out.println("get keywords from search bar: " + keywords);
        model.addAttribute("test", keywords);
        return "test";
    }


    @RequestMapping(name="/search")
    public String getSearchText(HttpServletRequest request, Model model) {
        String keywords = request.getParameter("keywords");
        System.out.println("get keywords from search bar:" + keywords);
        model.addAttribute("test", "keywords");
        return "test";
    }

    @RequestMapping(name="/search")
    @ResponseBody
    public String getSearchText(@RequestParam("keywords") String keywords) {
        System.out.println("get keywords from search bar: " + keywords);
        return keywords;
    }*/


}

