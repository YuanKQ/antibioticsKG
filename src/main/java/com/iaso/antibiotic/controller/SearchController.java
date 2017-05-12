package com.iaso.antibiotic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yuan on 17-5-10.
 */

@Controller
public class SearchController {
//  第一个页面：搜索栏+知识地图
    @RequestMapping(name="/search")
    public String getSearchText(String keywords, String graph, Model model) {
        System.out.println("get keywords from search bar: " + keywords);
        model.addAttribute("test", keywords);
        model.addAttribute("domain", graph);
        return "test";
    }


/*  以下两种方法与上述方法效果相同,此时注意search.html表单是以POST形式请求
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

