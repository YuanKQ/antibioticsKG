/********************************************
 * User: yuan
 * Date: 17-5-12 上午10:44
 * Email: kq_yuan@outlook.com
 *
 * Description: 控制导航栏跳转页面链接的controller
 *
 ********************************************/

package com.iaso.antibiotic.controller;

import com.iaso.antibiotic.model.Antibiotic;
import com.iaso.antibiotic.service.AntibioticService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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

    @RequestMapping(value = "/hello")
    public String hello(Model model) {
        model.addAttribute("name", " world");
        return "antibioticKG";
    }

    private AntibioticService antibioticService = new AntibioticService();

    @RequestMapping(value = "/test")
    @ResponseBody
    public String testMyBatis() {
        String name = "AmBisome";
        Antibiotic antibiotic = antibioticService.findAntibioticByName(name);
        return "×id     " + antibiotic.getId() + "<br>×name     " + antibiotic.getName()
                + "<br>*type    " + antibiotic.getType() + "<br>description     " + antibiotic.getDescription()
                + "<br>*indication  " + antibiotic.getDrug_indication();
    }

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

