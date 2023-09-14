package com.haotu.eventbus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.Executors;

public class AsyncPubMsg {
    private EventBus eventBus = new AsyncEventBus(Executors.newCachedThreadPool());
    private EventListener listener = new EventListener();

    public AsyncPubMsg() {
        eventBus.register(listener);
    }

    public void registerListener(EventListener listener) {
        eventBus.register(listener);
    }

    public void publishMsg(String msg) {
        System.out.println("publish msg: " + msg + " thread id: " + Thread.currentThread().getId());
        //get thread id
        eventBus.post(msg);
    }

    public void publishMsg(Integer msg) {
        System.out.println("publish msg: " + msg + " thread id: " + Thread.currentThread().getId());
        eventBus.post(msg);
    }
}
