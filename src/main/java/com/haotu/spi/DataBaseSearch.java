package com.haotu.spi;

import java.util.List;

public class DataBaseSearch implements Search{
    @Override
    public List<String> searchDoc(String keyword) {
        System.out.println("DataBaseSearch");
        return null;
    }
}
