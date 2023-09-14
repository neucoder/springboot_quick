package com.haotu.eventbus;

import com.google.common.eventbus.EventBus;

public class PubMsg {
    private EventBus eventBus = new EventBus();
    private EventListener listener = new EventListener();

    public PubMsg() {
        eventBus.register(listener);
    }

    public void registerListener(EventListener listener) {
        eventBus.register(listener);
    }

    public void publishMsg(String msg) {
        System.out.println("publish msg: " + msg + " thread id: " + Thread.currentThread().getId());
        eventBus.post(msg);
    }

    public void publishMsg(Integer msg) {
        System.out.println("publish msg: " + msg + " thread id: " + Thread.currentThread().getId());
        eventBus.post(msg);
    }

}
