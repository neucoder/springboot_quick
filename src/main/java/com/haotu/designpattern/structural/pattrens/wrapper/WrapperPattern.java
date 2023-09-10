package com.haotu.designpattern.structural.pattrens.wrapper;

class Voltage220 {
    public int output220() {
        return 220;
    }
}

interface Voltage5V {
    int output5();
}

// 适配器类
class VoltageAdapter extends Voltage220 implements Voltage5V {
    @Override
    public int output5() {
        int src = output220();
        int dst = src / 44;
        return dst;
    }
}

class VoltageAdapter2 implements Voltage5V {
    private Voltage220 voltage220;

    public VoltageAdapter2() {
        voltage220 = new Voltage220();
    }

    public VoltageAdapter2(Voltage220 voltage220) {
        this.voltage220 = voltage220;
    }

    @Override
    public int output5() {
        int dst = 0;
        if (voltage220 != null) {
            int src = voltage220.output220();
            dst = src / 44;
        }
        return dst;
    }
}

class PhoneClient {
    public void chargeing(Voltage5V voltage5V) {
        if (voltage5V.output5() == 5) {
            System.out.println("电压为5V，可以充电");
        } else if (voltage5V.output5() > 5) {
            System.out.println("电压大于5V，不能充电");
        }
    }
}

public class WrapperPattern {
    public static void main(String[] args) {
        PhoneClient phoneClient = new PhoneClient();
        phoneClient.chargeing(new VoltageAdapter());
        phoneClient.chargeing(new VoltageAdapter2());
    }
}
