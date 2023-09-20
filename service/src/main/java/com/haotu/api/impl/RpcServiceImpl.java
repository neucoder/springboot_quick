package com.haotu.api.impl;

import com.haotu.api.RpcCall;

public class RpcServiceImpl implements RpcCall {
    @Override
    public String call(String name) {
        System.out.println("调用RPC服务：call " + name);
        return null;
    }
}
