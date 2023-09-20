package com.haotu.spi;

import java.util.List;

public class FileSearch implements Search{
    @Override
    public List<String> searchDoc(String keyword) {
        System.out.println("FileSearch");
        return null;
    }
}
