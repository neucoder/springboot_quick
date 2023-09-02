package com.haotu.dao;

import org.springframework.stereotype.Repository;

@Repository
public class HelloRepository {

    public String queryById(Long id) {
        return "Hello, world!" + id;
    }
}
