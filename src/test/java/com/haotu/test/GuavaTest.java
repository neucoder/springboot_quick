package com.haotu.test;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.junit.jupiter.api.Test;

public class GuavaTest {

    @Test
    public void testTable() {

        Table<String, String, Integer> scores = HashBasedTable.create();
        scores.put("语文", "张三", 90);
        scores.put("数学", "张三", 95);
        scores.put("英语", "张三", 85);
        System.out.println(scores);
    }
}
