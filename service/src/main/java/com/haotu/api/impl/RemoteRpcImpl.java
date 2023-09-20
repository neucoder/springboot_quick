package com.haotu.api.impl;

import com.haotu.api.RpcCall;

public class RemoteRpcImpl implements RpcCall {
    @Override
    public String call(String name) {
        System.out.println("调用Remote RPC服务：call " + name);
        return null;
    }
}
