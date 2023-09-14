package com.haotu.designpattern.behavioral.patterns.iterator;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
//迭代器模式
class ListIterator implements Iterator {
    private List list;
    private int index;

    public ListIterator(List list) {
        this.list = list;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return Objects.nonNull(list) && index < list.size();
    }

    @Override
    public Object next() {
        Object object = list.get(index);
        index++;
        return object;
    }
}

class Phone {
    String name;
    String money;

    public Phone(String name, String money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
interface IPhone {
    //获取手机名称
    public String getName();
    //创建一个获取 Iterator 实例的方法
    public Iterator<Object> createIterator();
    //增加手机的方法
    public void add(String name,String type);
}

class XiaoMiPhoneImpl implements IPhone{
    //小米使用 list 存储产品
    private List<Phone> xiaoMis = new ArrayList<Phone>();
    //构造器
    public XiaoMiPhoneImpl() {
        add("红米", "1200");
        add("小米6", "2300");
        add("小米7", "3200");
    }

    @Override
    public String getName() {
        return "====小米手机====";
    }
    //创建遍历器
    @Override
    public Iterator<Object> createIterator() {
        return new ListIterator(xiaoMis);
    }
    //集合中添加小米产品
    @Override
    public void add(String name, String money) {
        xiaoMis.add(new Phone(name, money));
    }
}



public class IteratorPattern {
    public static void main(String[] args) {
        XiaoMiPhoneImpl xiaoMiPhone = new XiaoMiPhoneImpl();
        Iterator<Object> iterator = xiaoMiPhone.createIterator();
        while (iterator.hasNext()) {
            Phone phone = (Phone) iterator.next();
            System.out.println(phone.getName() + " " + phone.getMoney());
        }
        System.out.println("Iterator Pattern!");

    }
}
