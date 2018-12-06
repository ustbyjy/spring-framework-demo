package com.yjy.controller;

import com.yjy.service.MDCService1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MDCController {

    private static Logger logger = LoggerFactory.getLogger(MDCController.class);

    @Autowired
    private MDCService1 mdcService1;

    @RequestMapping("/mdc")
    public String mdc() {
        logger.info("in");

        mdcService1.doSomething();

        logger.info("out");

        return "success";
    }

}
