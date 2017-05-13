package com.iaso.antibiotic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by yuan on 17-5-10.
 */

@Controller
public class SearchController {
    //  搜索栏:搜索领域graph，搜索关键词keywords
    @RequestMapping(name="/search")
    public String testRedirect(String keywords, String graph, RedirectAttributes attr) {
//        System.out.println("get keywords from search bar: " + keywords);
        attr.addAttribute("keywords", keywords);
        return "redirect:/" + graph + "/hello";
    }


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

