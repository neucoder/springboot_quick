package com.haotu.service;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

//
@PrepareForTest(ExampleService.class)
public class ExampleServiceTest {

    @Test
    public void testAdd() throws Exception {
        //模拟私有方法，用一个对象作为参数传进去
        ExampleService spy = PowerMockito.spy(new ExampleService());
        PowerMockito.doReturn(100).when(spy, "add", 1, 1);
        System.out.println(spy.add_int(1, 1));
        System.out.println(spy.add_int(1, 1));

        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 1);
        PowerMockito.doReturn(new Point(100, 100)).
                when(spy, "addPoint",
                        p1, p2);
        System.out.println(spy.add2(p1, p2));
        System.out.println(spy.add2(p1, p2));
        System.out.println(spy.add2(p1, new Point(1,3)));

        //use slf4j and logback print log
        Logger logger =  LoggerFactory.getLogger(ExampleServiceTest.class);
        logger.info("hello world");
        logger.info("{}, {}", 12, 3);
        logger.warn("warn");
        logger.error("a error");
    }
}
