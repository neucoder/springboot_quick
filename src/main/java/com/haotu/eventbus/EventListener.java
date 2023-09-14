package com.haotu.eventbus;

import com.google.common.eventbus.Subscribe;

public class EventListener {

    @Subscribe
    public void ListenerInteger(Integer event) {
        System.out.println("Integer event: " + event + " thread id: " + Thread.currentThread().getId());
    }

    @Subscribe
    public void ListenerString(String event) {
        System.out.println("String event: " + event + " thread id: " + Thread.currentThread().getId());
    }
}
