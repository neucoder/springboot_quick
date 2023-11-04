package com.haotu.service;

import com.haotu.BaseTestNg;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

public class HelloServiceTest extends BaseTestNg {

    Logger logger =  LoggerFactory.getLogger(HelloServiceTest.class);

    @Resource
    private HelloService helloService;

    @Test
    public void testHello() {
        logger.info("{}-{}", "ad", 11);
        logger.error("this is a error");
        logger.warn("this is a warn");
    }
}
