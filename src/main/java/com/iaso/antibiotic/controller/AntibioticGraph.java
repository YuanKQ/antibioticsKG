/******************************
 * User: yuan
 * Date: 17-5-13 下午10:45
 * Email: kq_yuan@outlook.com
 *
 * Description: controller of antibioticKG.ftl
 *
 ******************************/
package com.iaso.antibiotic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/antibiotic")
public class AntibioticGraph {
    @RequestMapping("/hello")
    public String hello(String keywords, Model model) {
        model.addAttribute("test", keywords);
        return "antibioticKG";
    }
}
