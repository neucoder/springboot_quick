package com.haotu.designpattern.behavioral.patterns.observer;

import java.util.ArrayList;
import java.util.List;

interface IObserver {
    void update(String name, String content, String type);
}

interface ISubject {
    void addObserver(IObserver o);

    void removeObserver(IObserver o);

    void notifyObserver();
}

class SubjectImpl implements ISubject {
    private String name;
    private String content;
    private String type;
    List<IObserver> observers;

    public SubjectImpl() {
        observers = new ArrayList<>();
    }

    public SubjectImpl(String name, String content, String type) {
        this.name = name;
        this.content = content;
        this.type = type;
        observers = new ArrayList<>();
    }

    public void setAndNotifySubject(String name, String content, String type) {
        this.name = name;
        this.content = content;
        this.type = type;
        notifyObserver();
    }


    @Override
    public void addObserver(IObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(IObserver o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObserver() {
        for (IObserver o : observers) {
            o.update(name, content, type);
        }
    }
}

class ObserverImpl_A implements IObserver {

    @Override
    public void update(String name, String content, String type) {
        System.out.println("ObserverImpl_A: " + name + " " + content + " " + type);
    }
}

class ObserverImpl_B implements IObserver {

    @Override
    public void update(String name, String content, String type) {
        System.out.println("ObserverImpl_B: " + name + " " + content + " " + type);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        SubjectImpl subject = new SubjectImpl("name", "content", "type");
        subject.addObserver(new ObserverImpl_A());
        subject.addObserver(new ObserverImpl_B());
        subject.notifyObserver();

        subject.setAndNotifySubject("name2", "content2", "type2");
    }
}
