package com.haotu.designpattern.behavioral.patterns.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * 责任链模式
 */
class Request {
    private int id;
    private double price;

    public Request(int id, double price) {
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

abstract class Handler {
    // 组合一个自己
    Handler handler;
   //处理者的名称
    String name;

    public Handler(String name) {
        super();
        this.name = name;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public abstract void process(Request request);
}

//主任审批类
class CollegeHandler extends Handler {
    private static final double MAX_PRICE = 1000;

    public CollegeHandler(String name) {
        super(name);
    }

    @Override
    public void process(Request request) {
        if (request.getPrice() <= MAX_PRICE) {
            System.out.println("请求编号：" + request.getId() + "被" + name + "处理");
        } else {
            handler.process(request);
        }
    }
}
// 院长审批类
class DepartmentHandler extends Handler {
    private static final double PRICE_1  = 1000;
    private static final double PRICE_2  = 3000;

    public DepartmentHandler(String name) {
        super(name);
    }

    @Override
    public void process(Request request) {
        if (request.getPrice() <= PRICE_2 && request.getPrice() > PRICE_1) {
            System.out.println("请求编号：" + request.getId() + "被" + name + "处理");
        } else {
            handler.process(request);
        }
    }
}

//校长审批
class PresidentHandler extends Handler {
    private static final double PRICE_1  = 3000;

    public PresidentHandler(String name) {
        super(name);
    }

    @Override
    public void process(Request request) {
        if (request.getPrice() > PRICE_1) {
            System.out.println("请求编号：" + request.getId() + "被" + name + "处理");
        } else {
            handler.process(request);
        }
    }
}

public class Chain {
    public static void main(String[] args) {
        // 创建请求
        List<Request> requests = new ArrayList<>();
        requests.add(new Request(1, 500));
        requests.add(new Request(2, 1500));
        requests.add(new Request(3, 2500));
        requests.add(new Request(4, 3500));
        requests.add(new Request(5, 4500));
        // 创建处理者
        Handler collegeHandler = new CollegeHandler("主任");
        Handler departmentHandler = new DepartmentHandler("院长");
        Handler presidentHandler = new PresidentHandler("校长");
        // 设置处理者之间的关系
        departmentHandler.setHandler(collegeHandler);
        presidentHandler.setHandler(departmentHandler);
        collegeHandler.setHandler(presidentHandler);
        // 处理请求
        for (Request request : requests) {
            collegeHandler.process(request);
        }
    }
}
