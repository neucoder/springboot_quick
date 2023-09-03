package com.haotu.test;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

    private void timer() throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("timer task:" + LocalDateTime.now());
            }
        }, 1000);
        Thread.sleep(2000);
        timer.cancel();
    }


    @Test
    public void testTimer() throws InterruptedException {
        timer();

        System.out.println("Hello, world!");
    }
}
