package com.yjy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MDCService1 {

    private static Logger logger = LoggerFactory.getLogger(MDCService1.class);

    @Autowired
    private MDCService2 mdcService2;
    @Autowired
    private MDCService3 mdcService3;

    public void doSomething() {
        logger.info("doSomething");

        mdcService2.doSomething();

        mdcService3.doSomething();
    }

}
