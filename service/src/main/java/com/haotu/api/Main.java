package com.haotu.api;

import com.haotu.api.impl.RpcServiceImpl;

public class Main {
    public static void main(String[] args) {
        RpcServiceImpl rpcService = new RpcServiceImpl();
        rpcService.call("hello");
    }
}