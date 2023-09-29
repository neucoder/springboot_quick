package com.haotu.groovy;

import java.math.BigDecimal;

public class Demo {
    public static void main(String[] args) {
        BigDecimal a1 = new BigDecimal("3");
        BigDecimal a2 = new BigDecimal("1");
        System.out.println(a2.divide(a1, 2, BigDecimal.ROUND_HALF_UP));
    }
}
