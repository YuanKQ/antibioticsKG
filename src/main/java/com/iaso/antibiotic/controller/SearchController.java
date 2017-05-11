package com.iaso.antibiotic.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static java.awt.SystemColor.text;

/**
 * Created by yuan on 17-5-10.
 */

@Controller
public class SearchController {
    //    第一个页面：搜索栏+知识地图
    @RequestMapping(name="/search", method=RequestMethod.POST)
    public String getSearchText(HttpServletRequest request, Model model) {
        String keywords = request.getParameter("keywords");
        System.out.println("get keywords from search bar" + keywords);
        model.addAttribute("test", keywords);
        return "test";
    }
}

