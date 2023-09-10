package com.haotu.designpattern.structural.pattrens.proxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

//静态代理
interface Ticketing {
    void buyTicket();

    double getPrice();
}

class RailwaySite implements Ticketing {

    private double price;

    public RailwaySite(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void buyTicket() {
        System.out.println("火车站买票, 票价：" + price);
        // split line
        System.out.println("----------------------------------");
    }
}

class ProxyTicketSystem implements Ticketing {

    private RailwaySite railwaySite;
    //手续费
    private double serviceCharge = 10;

    public ProxyTicketSystem(RailwaySite railwaySite, double serviceCharge) {
        this.railwaySite = railwaySite;
        this.serviceCharge = serviceCharge;
    }

    public RailwaySite getRailwaySite() {
        return railwaySite;
    }

    public void setRailwaySite(RailwaySite railwaySite) {
        this.railwaySite = railwaySite;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    @Override
    public void buyTicket() {
        System.out.println("代理买票");
        System.out.println("代理收取手续费：" + serviceCharge);
        System.out.println("代理收取手续费后，代理买票票价：" + (railwaySite.getPrice() + serviceCharge));
        // split line
        System.out.println("----------------------------------");
    }

    @Override
    public double getPrice() {
        return railwaySite.getPrice() + serviceCharge;
    }
}
// jdk动态代理

class RailTicketImpl implements Ticketing {

    private double price;

    public RailTicketImpl(double price) {
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void buyTicket() {
        System.out.println("火车站买票, 票价：" + price);
        // split line
        System.out.println("----------------------------------");
    }

    @Override
    public double getPrice() {
        return price;
    }


}

class ProxyTicket {
    private Object target;
    private double serviceCharge = 10;

    public ProxyTicket(Object target, double serviceCharge) {
        this.target = target;
        this.serviceCharge = serviceCharge;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    @Override
    public String toString() {
        return "ProxyTicket{" +
                "target=" + target +
                ", serviceCharge=" + serviceCharge +
                '}';
    }

    public Object getInstance() {
        return java.lang.reflect.Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    if ("buyTicket".equals(method.getName())) {
                        System.out.println("代理买票");
                        System.out.println("代理收取手续费：" + serviceCharge);
                        double price = ((Ticketing)target).getPrice() + serviceCharge;
                        System.out.println("代理收取手续费后，代理买票票价：" + price);
                        // split line
                        System.out.println("----------------------------------");
                        return null;
                    } else if ("getPrice".equals(method.getName())) {
                        double price = (double) method.invoke(target, args) + serviceCharge;
                        return price;
                    }

                    return null;
                }
        );
    }
}

//cglib 动态代理
class StationTicketImpl {
    public String buyTicket() {
        System.out.println("火车站买票, 票价：100");
        return "火车站买票";
    }
}

class ProxyStationTicket implements MethodInterceptor {
    private Object target;

    public ProxyStationTicket(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理买票");
        System.out.println("代理收取手续费：" + 10);
        // 执行目标对象的方法
        Object invoke = method.invoke(target, objects);
        System.out.println("代理收取手续费后，代理买票票价：" + 110);
        return invoke;
    }
}



public class ProxyPattern {
    public static void main(String[] args) {
        RailwaySite railwaySite = new RailwaySite(100);
        ProxyTicketSystem proxyTicketSystem = new ProxyTicketSystem(railwaySite, 10);
        proxyTicketSystem.buyTicket();
        System.out.println("代理买票票价：" + proxyTicketSystem.getPrice());
        // split line ====
        System.out.println("==================================");


        ProxyTicket proxyTicket = new ProxyTicket(railwaySite, 10);
        Object instance = proxyTicket.getInstance();
        Ticketing ticketing = (Ticketing) instance;
        ticketing.buyTicket();
        System.out.println("代理买票票价：" + ticketing.getPrice());

        System.out.println("==================================");
        StationTicketImpl stationTicket = new StationTicketImpl();
        ProxyStationTicket proxyStationTicket = new ProxyStationTicket(stationTicket);
        StationTicketImpl proxyInstance = (StationTicketImpl) proxyStationTicket.getProxyInstance();
        proxyInstance.buyTicket();
    }
}
