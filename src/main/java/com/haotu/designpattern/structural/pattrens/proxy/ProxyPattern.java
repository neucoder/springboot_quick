package com.haotu.designpattern.structural.pattrens.proxy;

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

public class ProxyPattern {
    public static void main(String[] args) {
        RailwaySite railwaySite = new RailwaySite(100);
        ProxyTicketSystem proxyTicketSystem = new ProxyTicketSystem(railwaySite, 10);
        proxyTicketSystem.buyTicket();
        System.out.println("代理买票票价：" + proxyTicketSystem.getPrice());
    }
}
