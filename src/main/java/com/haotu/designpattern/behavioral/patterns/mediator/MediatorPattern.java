package com.haotu.designpattern.behavioral.patterns.mediator;

//中介者模式

import java.util.HashMap;
import java.util.Map;

interface Colleague {
    void sendMessage();
    String needs();
}

class Colleague_A implements Colleague {
    private Mediator mediator;

    public Colleague_A(Mediator mediator) {
        this.mediator = mediator;
        this.mediator.register(this);
    }


    @Override
    public void sendMessage() {
        mediator.getMessage(this);
    }

    @Override
    public String needs() {
        return "我是租客A，我想租一个两室一厅的房子";
    }
}

class Colleague_B implements Colleague {
    private Mediator mediator;

    public Colleague_B(Mediator mediator) {
        this.mediator = mediator;
        this.mediator.register(this);
    }

    @Override
    public void sendMessage() {
        mediator.getMessage(this);
    }

    @Override
    public String needs() {
        return "我是租客B，我想租一个两室一厅的房子";
    }
}
interface Mediator {
    //注册同事类
    void register(Colleague colleague);
    //获取消息
    void getMessage(Colleague colleague);

}

class ConcreateMediator implements Mediator {

    Map<String, Colleague> mediators = new HashMap<>();
    @Override
    public void register(Colleague colleague) {
        if (colleague instanceof Colleague_A) {
            mediators.put("colleague_A", colleague);
        } else if (colleague instanceof Colleague_B) {
            mediators.put("colleague_B", colleague);
        }
    }

    @Override
    public void getMessage(Colleague colleague) {
        if (colleague instanceof Colleague_A) {
            handler(colleague.needs());
            System.out.println("服务的当前对象为====租客A====");
            System.out.println("租客A 你的需求和租客B的需求一致，下面为你展示租客B的需求");
            String need_B = mediators.get("colleague_B").needs();
            System.out.println(need_B);
        } else if (colleague instanceof Colleague_B) {
            handler(colleague.needs());
            System.out.println("服务的当前对象为====租客B====");
            System.out.println("租客B 你的需求和租客A的需求一致，下面为你展示租客A的需求");
            String need_A = mediators.get("colleague_A").needs();
            System.out.println(need_A);
        }
    }
    private void handler(String needs) {
        System.out.println("中介者开始处理需求");
        System.out.println(needs);
    }
}

public class MediatorPattern {
    public static void main(String[] args) {
        Mediator mediator = new ConcreateMediator();
        Colleague colleague_A = new Colleague_A(mediator);
        Colleague colleague_B = new Colleague_B(mediator);
        colleague_A.sendMessage();
        //split line
        System.out.println("==================================");
        colleague_B.sendMessage();
        System.out.println("Hello World!");
    }
}
