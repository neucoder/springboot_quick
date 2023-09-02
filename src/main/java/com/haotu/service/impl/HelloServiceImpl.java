package com.haotu.service.impl;

import com.haotu.dao.HelloRepository;
import com.haotu.service.HelloService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HelloServiceImpl implements HelloService {

    @Resource
    private HelloRepository helloRepository;
    @Override
    public void sayHello() {
        String s = helloRepository.queryById(1L);
        System.out.println(s);
    }
}
