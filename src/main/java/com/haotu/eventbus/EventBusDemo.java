package com.haotu.eventbus;

public class EventBusDemo {
    public static void main(String[] args) {
        PubMsg pubMsg = new PubMsg();
        pubMsg.publishMsg("hello");
        pubMsg.publishMsg(123);

        AsyncPubMsg asyncPubMsg = new AsyncPubMsg();
        asyncPubMsg.publishMsg("world");
        asyncPubMsg.publishMsg(456);
        System.exit(0);
    }
}
