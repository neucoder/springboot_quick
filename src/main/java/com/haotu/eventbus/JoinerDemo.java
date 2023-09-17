package com.haotu.eventbus;

import com.google.common.base.Joiner;

public class JoinerDemo {
    public static void main(String[] args) {
        String str = Joiner.on(",").useForNull("aa").join("a", "b", null, "c");
        System.out.println(str);
        str = Joiner.on("--").join(1, 2, 3);
        System.out.println(str);
        //sum 1 to 100 cale time
        long start = System.currentTimeMillis();
        long sum = 0;
        int N = 100000000;
        for (int i = 0; i < N; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum: " + sum + " time: " + (end - start));
    }
}
