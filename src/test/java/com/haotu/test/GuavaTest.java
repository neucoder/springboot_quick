package com.haotu.test;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class GuavaTest {

    @Test
    public void testTable() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "haha");
        System.out.println(JSON.toJSONString(map));

        String jsonStr = "{\"a\":\"haha\"}";
        TypeReference<Map<String, String>> typeReference = new TypeReference<Map<String, String>>() {
        };
        Map<String, String> map1 = JSON.parseObject(jsonStr, typeReference);

        HashMap hashMap = JSON.parseObject(jsonStr, HashMap.class);
        System.out.println(hashMap);


        Table<String, String, Integer> scores = HashBasedTable.create();
        scores.put("语文", "张三", 90);
        scores.put("数学", "张三", 95);
        scores.put("英语", "张三", 85);
        System.out.println(scores);
        // int to string
        int i_1 = 12;
        String s_1 = String.valueOf(i_1);
        System.out.println(s_1);
    }
}
