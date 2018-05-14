package com.yjy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Slf4j
@Controller
@RequestMapping("/cors")
public class CorsController {

    @RequestMapping(value = "/view")
    public String cors() {
        return "cors";
    }

    @CrossOrigin(origins = {"http://spring-framework.yjy.com"}, maxAge = 3600)
    @RequestMapping(value = "/api1")
    public ModelAndView api1() {
        return generateOkResponse();
    }

    @RequestMapping(value = "/api2")
    public ModelAndView api2() {
        return generateOkResponse();
    }

    @RequestMapping(value = "/api3")
    public ModelAndView api3() {
        return generateOkResponse();
    }

    private ModelAndView generateOkResponse() {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        modelAndView.addObject("status", 200);
        modelAndView.addObject("msg", "success");

        return modelAndView;
    }

}
