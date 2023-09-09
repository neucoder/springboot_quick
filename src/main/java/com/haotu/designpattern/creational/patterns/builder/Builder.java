package com.haotu.designpattern.creational.patterns.builder;

/**
 * 建造者模式
 */

class Computer {
    private String cpu;
    private String screen;
    private String memory;
    private String mainboard;

    private String ssd;

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public void setMainboard(String mainboard) {
        this.mainboard = mainboard;
    }

    public String getSsd() {
        return ssd;
    }

    public void setSsd(String ssd) {
        this.ssd = ssd;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", screen='" + screen + '\'' +
                ", memory='" + memory + '\'' +
                ", mainboard='" + mainboard + '\'' +
                ", ssd='" + ssd + '\'' +
                '}';
    }
}

abstract class BaseBuilder {
    Computer computer = new Computer();
    abstract public BaseBuilder buildCpu(String cpu);
    abstract public BaseBuilder buildScreen(String screen);
    abstract public BaseBuilder buildMemory(String memory);
    abstract public BaseBuilder buildMainboard(String mainboard);
    abstract public BaseBuilder buildSsd(String ssd);
    public Computer build() {
        return computer;
    };
}
class ComputerBuilder extends BaseBuilder{
    private Computer computer;

    public ComputerBuilder() {
        computer = new Computer();
    }

    public ComputerBuilder buildCpu(String cpu) {
        computer.setCpu(cpu);
        return this;
    }

    public ComputerBuilder buildScreen(String screen) {
        computer.setScreen(screen);
        return this;
    }

    public ComputerBuilder buildMemory(String memory) {
        computer.setMemory(memory);
        return this;
    }

    public ComputerBuilder buildMainboard(String mainboard) {
        computer.setMainboard(mainboard);
        return this;
    }

    public ComputerBuilder buildSsd(String ssd) {
        computer.setSsd(ssd);
        return this;
    }

    public Computer build() {
        return computer;
    }
}

class Director {
    BaseBuilder builder = null;
    public Director(BaseBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder(BaseBuilder builder) {
        this.builder = builder;
    }

    public Computer pack_pc() {
        builder.buildMainboard("华硕主板").buildCpu("i7").buildMemory("16g").buildScreen("三星显示器").buildSsd("三星SSD");
        return builder.build();
    }
}

public class Builder {
    public static void main(String[] args) {
        Director director = new Director(new ComputerBuilder());
        Computer computer = director.pack_pc();
        System.out.println(computer.getSsd());
        System.out.println(computer);
        StringBuilder sb = new StringBuilder();
        String str = sb.append("hello").append("--").append("world--").append(12).append("--").
                append(true).append("--").append(12.3).toString();
        System.out.println(str);
    }
}
