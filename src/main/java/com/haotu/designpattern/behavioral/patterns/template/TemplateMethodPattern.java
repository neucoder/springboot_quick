package com.haotu.designpattern.behavioral.patterns.template;

/**
 * 模板方法模式
 */

abstract class AbstractHospital {
    public final void process() {
        //挂号
        register();
        //看病
        queue();
        //缴费
        treat();
        //取药
        if (isRecipe()) {
            recipe();
        }
    }

    public abstract String recipe();

    boolean isRecipe() {
        return true;
    }

    public abstract String treat();


    private void queue() {
        System.out.println("排队中...");
    }

    private String register() {
        String regiest = "你的挂号信息：" + ((int) (Math.random() * 10)) + "号";
        System.out.println(regiest);
        return regiest;
    }

}

class Patient_A extends AbstractHospital {

    @Override
    public String recipe() {
        String recipe = "健胃消食片";
        System.out.println("取药：" + recipe);
        return recipe;
    }

    @Override
    public String treat() {
        String treat = "胃病";
        System.out.println("看病：" + treat);
        return treat;
    }

    @Override
    boolean isRecipe() {
        return false;
    }
}

class Patient_B extends AbstractHospital {

    @Override
    public String recipe() {
        String recipe = "感冒灵";
        System.out.println("取药：" + recipe);
        return recipe;
    }

    @Override
    public String treat() {
        String treat = "感冒";
        System.out.println("看病：" + treat);
        return treat;
    }

    @Override
    boolean isRecipe() {
        return super.isRecipe();
    }
}
public class TemplateMethodPattern {
    public static void main(String[] args) {
        AbstractHospital patient_A = new Patient_A();
        patient_A.process();
        System.out.println("==================================");
        AbstractHospital patient_B = new Patient_B();
        patient_B.process();

    }
}
