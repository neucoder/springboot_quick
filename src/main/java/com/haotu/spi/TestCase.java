package com.haotu.spi;

import com.haotu.api.RpcCall;

import java.util.ServiceLoader;

public class TestCase {
    public static void main(String[] args) {

        for (RpcCall call : ServiceLoader.load(RpcCall.class)) {
            call.call("hello");
        }
    }
}

