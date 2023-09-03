package com.haotu.schedule;

import com.haotu.BaseTestNg;
import com.haotu.shcedule.ScheduleDemo;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

public class ShceduleDemoTest extends BaseTestNg {

    @Resource
    private ScheduleDemo scheduleDemo;


    @Test
    public void testSchedule() throws Exception {
        //scheduleDemo.runScheduleCron();
        //scheduleDemo.runScheduleFixedRate();
        //scheduleDemo.runScheduleFixedRateException();
        //scheduleDemo.runScheduleFixedRateException2();

        while (true){}
    }
}
