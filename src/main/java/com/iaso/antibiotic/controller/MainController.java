/********************************************
 * User: yuan
 * Date: 17-5-12 上午10:44
 * Email: kq_yuan@outlook.com
 *
 * Description: 控制导航栏跳转页面链接的controller
 *
 ********************************************/

package com.iaso.antibiotic.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping(value = "/treeShow")
    public String treeName() {
        return "treeShow";
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
}

