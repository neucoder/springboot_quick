package com.haotu.designpattern.creational.patterns.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 原型模式
 * 手机原型类
 */
public class PhonePrototype implements Cloneable, Serializable {
    // 品牌
    private String name;
    // 号码
    private String number;
    public PhonePrototype(String name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        PhonePrototype  phonePrototype = null;
        try {
           phonePrototype = (PhonePrototype) super.clone(); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return phonePrototype;
    }

    @Override
    public String toString() {
        return "PhonePrototype{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    //通过序列化方式实现深拷贝
    public Object deepClone() {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            return (PhonePrototype) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        PhonePrototype huawei = (PhonePrototype)new PhonePrototype("huawei", "123456").clone();
        Object huawei_ = huawei.deepClone();
        System.out.println(huawei_);

        System.out.println(huawei);
    }
}
