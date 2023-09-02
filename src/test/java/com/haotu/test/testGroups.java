package com.haotu.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testGroups {

    @BeforeMethod(groups = {"group1"})
    public void beforeMethod() {
        System.out.println("beforeMethod group1");
    }

    @BeforeMethod(groups = {"group2"})
    public void beforeMethod2() {
        System.out.println("beforeMethod group2");
    }

    @BeforeGroups(groups = {"group1"})
    public void beforeGroups() {
        System.out.println("beforeGroups group1");
    }

    @BeforeTest(groups = {"group1"})
    public void beforeTest() {
        System.out.println("beforeTest group1");
    }



    @Test(groups = {"group1"})
    public void testGroup1() {
        System.out.println("test group1");
    }


    @Test(groups = {"group2"})
    public void testGroup2() {
        System.out.println("test group2");
    }

    @AfterMethod(groups = {"group1"})
    public void afterMethod() {
        System.out.println("afterMethod group1");
    }

    @AfterMethod(groups = {"group2"})
    public void afterMethod2() {
        System.out.println("afterMethod group2");
    }
}
