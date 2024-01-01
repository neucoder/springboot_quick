package com.main;

import com.common.niubi.Hello;
import com.common.niubi.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        Test test = new Test();
        test.print();
        Hello hello = new Hello();
        hello.sayHello();
        invokeAnotherTest();
    }

    static class MyClassLoader extends URLClassLoader{

        public MyClassLoader(URL[] urls) {
            super(urls);
        }

        public Class<?> loadClass(String name) throws ClassNotFoundException {
            if ("com.common.niubi.Test".equals(name)) {
                return super.findClass(name);
            }
            return super.loadClass(name);
        }
    }
    public static void invokeAnotherTest() throws MalformedURLException {
        String jarPath = "C:\\Users\\ys\\code\\springboot_quick\\test\\target\\mytest-1.0.0-SNAPSHOT.jar";
        URLClassLoader myLoader = new MyClassLoader(new URL[]{new File(jarPath).toURI().toURL()});
        try {
            Class<?> clazz = myLoader.loadClass("com.common.niubi.Test");
            Object obj = clazz.newInstance();
            clazz.getMethod("print").invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
