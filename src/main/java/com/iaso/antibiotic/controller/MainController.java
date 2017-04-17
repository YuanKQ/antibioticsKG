package com.iaso.antibiotic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yuan on 4/9/17.
 */
@Controller
public class MainController {
    @RequestMapping(value = "/test.do",method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
