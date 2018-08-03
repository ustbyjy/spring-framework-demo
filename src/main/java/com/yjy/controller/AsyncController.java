package com.yjy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/async")
@Slf4j
public class AsyncController {

    private static Map<String, DeferredResult<String>> deferredResultMap = new ConcurrentHashMap<>();

    @GetMapping("/callable")
    @ResponseBody
    public Callable<String> callable() {
        log.info("进入控制器...");
        return new Callable<String>() {
            public String call() throws Exception {
                log.info("处理业务...");
                TimeUnit.SECONDS.sleep(3);

                return "success";
            }
        };
    }

    @GetMapping("/deferredResult")
    @ResponseBody
    public DeferredResult<String> deferredResult() {
        log.info("进入控制器...");
        DeferredResult<String> deferredResult = new DeferredResult<String>(10000L);
        String uuid = UUID.randomUUID().toString();
        log.info("uuid={}", uuid);

        deferredResultMap.put(uuid, deferredResult);

        return deferredResult;
    }

    @GetMapping("/deferredResult/callback")
    @ResponseBody
    public String deferredResult(String uuid) {
        log.info("进入控制器...");

        DeferredResult<String> deferredResult = deferredResultMap.get(uuid);
        if (deferredResult != null) {
            deferredResult.setResult(uuid);
//            deferredResult.setErrorResult(new RuntimeException("deferredResult error"));
        }

        return "success";
    }

}
