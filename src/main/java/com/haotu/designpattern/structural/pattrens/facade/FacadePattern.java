package com.haotu.designpattern.structural.pattrens.facade;

class Cpu {
    private static Cpu cpu = new Cpu();
    private Cpu() {}
    public static Cpu getInstance() {
        return cpu;
    }
    public void open() {
        System.out.println("cpu open");
    }
    public void close() {
        System.out.println("cpu close");
    }
}

class Memory {
    private static Memory memory = new Memory();
    private Memory() {}
    public static Memory getInstance() {
        return memory;
    }
    public void open() {
        System.out.println("memory open");
    }
    public void close() {
        System.out.println("memory close");
    }
}


class Hard {
    private static Hard hard = new Hard();
    private Hard() {}
    public static Hard getInstance() {
        return hard;
    }
    public void open() {
        System.out.println("hard open");
    }
    public void close() {
        System.out.println("hard close");
    }
}

class Facade {
    private Cpu cpu;
    private Memory memory;
    private Hard hard;

    public Facade() {
        cpu = Cpu.getInstance();
        memory = Memory.getInstance();
        hard = Hard.getInstance();
    }

    public void open() {
        cpu.open();
        memory.open();
        hard.open();
    }

    public void close() {
        cpu.close();
        memory.close();
        hard.close();
    }
}

public class FacadePattern {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.open();
        facade.close();
    }
}
