package com.haotu.designpattern.structural.pattrens.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 * 部分整体模式，将对象组合成树形结构以表示“部分-整体”的层次结构。
 */
abstract class AbstractComponent {
    private String name;
    private String remark;

    public AbstractComponent(String name, String remark) {
        this.name = name;
        this.remark = remark;
    }

    public abstract void output();
    public void add(AbstractComponent component) {
        throw new UnsupportedOperationException();
    }
    public void remove(AbstractComponent component) {
        throw new UnsupportedOperationException();
    }
    public AbstractComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

class university extends AbstractComponent {
    public university(String name, String remark) {
        super(name, remark);
    }
    List<AbstractComponent> college  = new ArrayList<>();

    @Override
    public void output() {
        System.out.println("====" + super.getName() + "====");
        for (AbstractComponent component : college) {
            component.output();
        }
        // split line
        System.out.println("----------------------------------");
    }

    // 重写add方法
    @Override
    public void add(AbstractComponent component) {
        college.add(component);
    }
    // 重写remove方法
    @Override
    public void remove(AbstractComponent component) {
        college.remove(component);
    }
}

class College extends AbstractComponent {
    public College(String name, String remark) {
        super(name, remark);
    }
    List<AbstractComponent> department  = new ArrayList<>();

    @Override
    public void output() {
        System.out.println("====" + super.getName() + "====");
        for (AbstractComponent component : department) {
            component.output();
        }
        // split line
        System.out.println("----------------------------------");
    }

    // 重写add方法
    @Override
    public void add(AbstractComponent component) {
        department.add(component);
    }

    // 重写remove方法
    @Override
    public void remove(AbstractComponent component) {
        department.remove(component);
    }
}

class Major extends AbstractComponent {
    public Major(String name, String remark) {
        super(name, remark);
    }

    @Override
    public void output() {
        System.out.println("====" + super.getName() + "====");
        // split line
        System.out.println("----------------------------------");
    }
}



public class CompositePattern {
    public static void main(String[] args) {
        university university = new university("浙江大学", "浙江人的骄傲");
        College college = new College("计算机学院", "计算机学院");
        College college2 = new College("电子信息学院", "电子信息学院");
        university.add(college);
        university.add(college2);
        Major major = new Major("软件工程", "软件工程");
        Major major2 = new Major("计算机科学与技术", "计算机科学与技术");
        college.add(major);
        college.add(major2);
        Major major3 = new Major("电子信息工程", "电子信息工程");
        Major major4 = new Major("通信工程", "通信工程");
        college2.add(major3);
        college2.add(major4);
        university.output();
        college.output();
        college2.output();
    }
}
