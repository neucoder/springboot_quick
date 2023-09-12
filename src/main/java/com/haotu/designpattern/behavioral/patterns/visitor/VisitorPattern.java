package com.haotu.designpattern.behavioral.patterns.visitor;

import java.util.ArrayList;
import java.util.List;

interface Action {
    void getJudge_A(Judge_A judge_a);
    void getJudge_B(Judge_B judge_b);
}


class ActionGuilt implements Action {
    @Override
    public void getJudge_A(Judge_A judge_a) {
        System.out.println(judge_a.getName() + "法官判决" + " guilt " + judge_a.getClass().getSimpleName());
    }

    @Override
    public void getJudge_B(Judge_B judge_b) {
        System.out.println(judge_b.getName() + "法官判决" + " guilt " + judge_b.getClass().getSimpleName());
    }
}

class ActionInnocent implements Action {
    @Override
    public void getJudge_A(Judge_A judge_a) {
        System.out.println(judge_a.getName() + "法官判决" + " innocent " + judge_a.getClass().getSimpleName());
    }

    @Override
    public void getJudge_B(Judge_B judge_b) {
        System.out.println(judge_b.getName() + "法官判决" + " innocent " + judge_b.getClass().getSimpleName());
    }
}

interface Judge {
    void accept(Action action);
}

class Judge_A implements Judge {
    private String name;
    @Override
    public void accept(Action action) {
        action.getJudge_A(this);
    }

    public Judge_A(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Judge_B implements Judge {
    private String name;
    @Override
    public void accept(Action action) {
        action.getJudge_B(this);
    }

    public Judge_B(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class ObjectStructure {
    private List<Judge> judges = new ArrayList<>();

    public void attach(Judge judge) {
        judges.add(judge);
    }

    public void detach(Judge judge) {
        judges.remove(judge);
    }

    public void display(Action action) {
        for (Judge judge : judges) {
            judge.accept(action);
        }
    }
}

public class VisitorPattern {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.attach(new Judge_A("A"));
        objectStructure.attach(new Judge_B("B"));

        Action actionGuilt = new ActionGuilt();
        objectStructure.display(actionGuilt);

        Action actionInnocent = new ActionInnocent();
        objectStructure.display(actionInnocent);

        objectStructure.display(new Action() {
            @Override
            public void getJudge_A(Judge_A judge_a) {
                System.out.println("匿名判决" + judge_a.getName() + " guilt " + judge_a.getClass().getSimpleName());
            }

            @Override
            public void getJudge_B(Judge_B judge_b) {
                System.out.println("匿名判决" + judge_b.getName() + " guilt " + judge_b.getClass().getSimpleName());
            }
        });
    }
}
