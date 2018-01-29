/********************************************
 * User: yuan
 * Date: 17-5-12 上午10:44
 * Email: kq_yuan@outlook.com
 *
 * Description: 控制导航栏跳转页面链接的controller
 *
 ********************************************/

package com.iaso.antibiotic.controller;

import com.iaso.antibiotic.service.AntibioticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {
//    @RequestMapping(value = "/index",method = RequestMethod.GET)
//    public String index() {
//        return "index";
//    }
//
//    @RequestMapping(value = "/introduce",method = RequestMethod.GET)
//    public String introduce() {
//        return "introduce";
//    }
    @Autowired
    private AntibioticService antibioticService;

    @RequestMapping(value = "/treeShow")
    public String treeName() {
        return "treeShow";
    }

    @RequestMapping(value = "/nametest")
    public List<String> findName() {
        List<String> names = antibioticService.findAllantibioticName();
        return names;
    }

    @RequestMapping(value = "/")
    public String systemIntroducePage1(Model model) {
        // 设置默认首页显示
        return "introduction";
    }
    @RequestMapping(value = "/hello")
    public String hello(Model model) {
        /* 将值传递至前端(ftl), 前端通过{name}, {graph}, {kw}来引用
        model.addAttribute("name", " world");
        model.addAttribute("graph", "antibiotic");
        model.addAttribute("kw","AmBisome");
        */
        return "antibioticKG";
    }

    @RequestMapping(value = "/antibioticKG")
    public String antibioticaWebPage(Model model) {
        /* 将值传递至前端(ftl), 前端通过{name}, {graph}, {kw}来引用
        model.addAttribute("name", " world");
        model.addAttribute("graph", "antibiotic");
        model.addAttribute("kw","AmBisome");
        */
        return "antibioticKG";
    }

    @RequestMapping(value = "/notFound")
    public String notFoundPage(Model model) {
        /* 将值传递至前端(ftl), 前端通过{name}, {graph}, {kw}来引用
        model.addAttribute("name", " world");
        model.addAttribute("graph", "antibiotic");
        model.addAttribute("kw","AmBisome");
        */
        return "notFound";
    }

    @RequestMapping(value = "/introduction")
    public String systemIntroducePage(Model model) {
        return "introduction";
    }

    @RequestMapping(value = "/dataDownload")
    public String dataDownloadPage(Model model) {
        return "dataDownload";
    }

    @RequestMapping(value = "/apiTutorial")
    public String apiTutorialPage(Model model) {
        return "apiTutorial";
    }

    @RequestMapping(value = "/test")
    public String testPage(Model model) {
        return "test";
    }


    @RequestMapping(value = "/TreeShow")
    public String TreeShowPage(Model model) {
        /* 将值传递至前端(ftl), 前端通过{name}, {graph}, {kw}来引用
        model.addAttribute("name", " world");
        model.addAttribute("graph", "antibiotic");
        model.addAttribute("kw","AmBisome");
        */
        return "/WEB-INF/FTL/treeShow.ftl";
    }


/*
    @RequestMapping(value = "/test")
    @ResponseBody
    public String testMyBatis() {
        */
/* 测试Ｍｙｂａｔｉｓ返回对象　Ａｎｔｉｂｉｏｔｉｃ
        String name = "AmBisome";
        Antibiotic antibiotic = antibioticService.findAntibioticByName(name);
        return "×id     " + antibiotic.getId() + "<br>×name     " + antibiotic.getName()
                + "<br>*type    " + antibiotic.getType() + "<br>description     " + antibiotic.getDescription()
                + "<br>*indication  " + antibiotic.getDrug_indication();
        *//*


        */
/* 测试findAllNodeID
        String id = "31e104dd-d685-11e6-82b5-3497f68b8eda";
        List<String> idList = antibioticService.findAllNodeID(id);
        String idStr = "";
        int count = 0;
        for (String item: idList) {
            String temp = item + "<br>";
            idStr += temp;
            count ++;
        }

        return idStr;*//*


       */
/* 测试findBacteriaByID
        List<String> idList = new ArrayList<String>();
        idList.add("34fa29c9-d681-11e6-82b5-3497f68b8eda");
        idList.add("34fa49b3-d681-11e6-82b5-3497f68b8eda");
        idList.add("34fa60c9-d681-11e6-82b5-3497f68b8eda");
        idList.add("34fa7ad7-d681-11e6-82b5-3497f68b8eda");
        List<Bacteria> bacteriaList = antibioticService.findBcateriaByID(idList);
        String showStr = "";
        for (Bacteria b: bacteriaList) {
            String tmp = "id: " + b.getBacteriaId() + "<br>name: " + b.getBacteriaName()
                    + "<br>type: " + b.getBacteriaType() + "<br>description: " + b.getDescription() + "<br><hr><br>";
            showStr += tmp;
        }

        return showStr;*//*


        */
/*测试findSituationByID
        List<String> idList = new ArrayList<String>();
        idList.add("d3466268-d687-11e6-82b5-3497f68b8eda");
        idList.add("d3467cac-d687-11e6-82b5-3497f68b8eda");
        idList.add("d3468b10-d687-11e6-82b5-3497f68b8eda");
        idList.add("d3469d9c-d687-11e6-82b5-3497f68b8eda");
        List<Situation> resultList = antibioticService.findSituationByID(idList);
        String showStr = "";
        for (Situation s: resultList) {
            String tmp = "id: " + s.getSituationId() + "<br>name: " + s.getSituationName() + "<br><hr><br>";
            showStr += tmp;
        }

        return showStr;*//*


        */
/*List<String> idList = new ArrayList<String>();
        idList.add("31e104dd-d685-11e6-82b5-3497f68b8eda");
        idList.add("31e12f96-d685-11e6-82b5-3497f68b8eda");
        idList.add("31e18cfb-d685-11e6-82b5-3497f68b8eda");
        idList.add("31e197a0-d685-11e6-82b5-3497f68b8eda");
        String id = "31e197a0-d685-11e6-82b5-3497f68b8eda";

        List<Antibiotic> antibioticList = antibioticService.findAntibioticByID(id, idList);
        String showStr = "";
        for (Antibiotic antibiotic: antibioticList) {
            String tmp = "id     " + antibiotic.getId() + "<br>name     " + antibiotic.getName()
                    + "<br>type    " + antibiotic.getType() + "<br>description     " + antibiotic.getDescription()
                    + "<br>indication  " + antibiotic.getDrug_indication() + "<br><hr><br>";
            showStr += tmp;
        }
        return showStr;*//*


        return "None";
    }
*/

     /*
    //该写法与public String hello()运行效果一致
    @RequestMapping(value = "/hello")
    public String hello(Model model) {
        model.addAttribute("name", " world");
        return "next";
    }


    @RequestMapping(value = "/hello")
    public ModelAndView hello(HttpServletRequest request,HttpServletResponse response) {
        ModelAndView model = new ModelAndView();
        model.addObject("name", "张三");
        return model;
    }
    */



}

