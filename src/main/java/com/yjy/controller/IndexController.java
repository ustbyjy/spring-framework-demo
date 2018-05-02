package com.yjy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(HttpServletRequest request, Model model) {
        System.out.println(request.getServletContext().getAttribute("myData"));
        return "index";
    }

    @RequestMapping("/demo")
    @ResponseBody
    public String demo(HttpServletRequest request, HttpServletResponse response, String sign) {
        System.out.println(sign);
        return "success";
    }

    @RequestMapping("/exception")
    @ResponseBody
    public String testException() {
        throw new RuntimeException();
    }

}
