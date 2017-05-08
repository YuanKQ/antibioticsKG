package com.iaso.antibiotic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by yuan on 4/9/17.
 */
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

    @RequestMapping(value = "/hello")
    public String hello(Model model) throws UnsupportedEncodingException {
//        String name = URLEncoder.encode(, "utf-8");
        model.addAttribute("name", "张三");
        return "hello";
    }
}

