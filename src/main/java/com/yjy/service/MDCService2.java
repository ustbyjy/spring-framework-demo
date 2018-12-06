package com.yjy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MDCService2 {

    private static Logger logger = LoggerFactory.getLogger(MDCService2.class);

    public void doSomething() {
        logger.info("doSomething");
    }

}
