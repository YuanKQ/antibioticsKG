package com.iaso.antibiotic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by yuan on 4/9/17.
 */
@Controller
public class MainController {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/introduce",method = RequestMethod.GET)
    public String introduce() {
        return "introduce";
    }

    /*两种写法都可以
    @RequestMapping(value = "/hello")
    public ModelAndView hello(HttpServletRequest request,HttpServletResponse response) {
        ModelAndView model = new ModelAndView();
        model.addObject("name", "张三");
        return model;
    }
    */

    @RequestMapping(value = "/hello")
    public String hello(Model model) {
        model.addAttribute("name", "张三");
        return "hello";
    }




}

