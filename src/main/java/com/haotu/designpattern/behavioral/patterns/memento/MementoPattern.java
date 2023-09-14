package com.haotu.designpattern.behavioral.patterns.memento;
//备忘录模式

import java.util.HashMap;
import java.util.Map;

class Memento {
    private String name;
    private int timestamp;

    public Memento(String name, int timestamp) {
        this.name = name;
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }
}
class Original {
    private String name;
    private int timestamp;

    public Memento createMemento() {
        return new Memento(name, timestamp);
    }

    public void getOriginalFromMemento(Memento memento) {
        this.name = memento.getName();
        this.timestamp = memento.getTimestamp();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Original{" +
                "name='" + name + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}

class CareTaker {
    private int index = 1;
    Map<Integer, Memento> mementoMap  = new HashMap<>();

    public void addMemento(Memento memento) {
        mementoMap.put(index, memento);
        index++;
    }

    public Memento getMemento(int index) {
        return mementoMap.get(index);
    }

    public void removeMemento(int index) {
        mementoMap.remove(index);
    }

    public void removeAll() {
        mementoMap.clear();
    }
}
public class MementoPattern {
    public static void main(String[] args) {
        Original original = new Original();
        CareTaker managerMemento = new CareTaker();
        original.setName("张三");
        original.setTimestamp(2230);
        Memento memento = original.createMemento();
        managerMemento.addMemento(memento);
        original.setName("李四");
        original.setTimestamp(2231);
        memento = original.createMemento();
        managerMemento.addMemento(memento);
        original.setName("王五");
        original.setTimestamp(2232);
        memento = original.createMemento();
        managerMemento.addMemento(memento);

        memento = managerMemento.getMemento(1);
        original.getOriginalFromMemento(memento);
        System.out.println(original);

        memento = managerMemento.getMemento(2);
        original.getOriginalFromMemento(memento);
        System.out.println(original);
    }
}
