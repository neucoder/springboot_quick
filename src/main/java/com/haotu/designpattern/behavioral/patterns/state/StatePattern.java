package com.haotu.designpattern.behavioral.patterns.state;

import java.util.Random;

interface State {
    //扣除积分
    void deduceMoney();
    //是否抽中奖品
    boolean raffle();
    //发放奖品
    void dispensePrize();

}

class Activity {
    private State state;

    private int count;

    NoRaffleState noRaffleState = new NoRaffleState(this);
    CanRaffeState canRaffleState = new CanRaffeState(this);
    DispenseState dispenseState = new DispenseState(this);
    DispenseOutState dispenseOutState = new DispenseOutState(this);

    public Activity(int count) {
        this.state = noRaffleState;
        this.count = count;
    }

    public void deduceMoney() {
        state.deduceMoney();
    }

    public void raffle() {
        if (state.raffle()) {
            state.dispensePrize();
        }
    }

    public int getCount() {
        int curCount = count;
        count--;
        return curCount;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public NoRaffleState getNoRaffleState() {
        return noRaffleState;
    }

    public CanRaffeState getCanRaffleState() {
        return canRaffleState;
    }

    public DispenseState getDispenseState() {
        return dispenseState;
    }

    public DispenseOutState getDispenseOutState() {
        return dispenseOutState;
    }
}

class NoRaffleState implements State {
    private Activity activity;

    public NoRaffleState(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void deduceMoney() {
        System.out.println("扣除50积分，您可以抽奖了");
        activity.setState(activity.getCanRaffleState());
    }

    @Override
    public boolean raffle() {
        System.out.println("扣除积分后才能抽奖");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("不能分发奖品");
    }
}


class CanRaffeState implements State {
    Activity activity;

    public CanRaffeState(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void deduceMoney() {
        System.out.println("您已经扣除过积分了");
    }

    @Override
    public boolean raffle() {
        System.out.println("正在抽奖，请稍等");
        int num = new Random().nextInt(3);
        if (num == 0) {
            activity.setState(activity.getDispenseState());
            return true;
        } else {
            System.out.println("很遗憾，没有抽中奖品");
            activity.setState(activity.getNoRaffleState());
            return false;
        }
    }

    @Override
    public void dispensePrize() {
        System.out.println("抽奖中，不能发放奖品");
    }
}

class DispenseState implements State {
    Activity activity;

    public DispenseState(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void deduceMoney() {
        System.out.println("不能扣除积分");
    }

    @Override
    public boolean raffle() {
        System.out.println("不能抽奖");
        return false;
    }

    @Override
    public void dispensePrize() {
        if (activity.getCount() > 0) {
            System.out.println("恭喜中奖");
            activity.setState(activity.getNoRaffleState());
        } else {
            System.out.println("很遗憾，奖品已经发放完了");
            activity.setState(activity.getDispenseOutState());
        }
    }
}

class DispenseOutState implements State {
    Activity activity;

    public DispenseOutState(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void deduceMoney() {
        System.out.println("活动结束");
    }

    @Override
    public boolean raffle() {
        System.out.println("活动结束");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("活动结束");
    }
}




public class StatePattern {
    public static void main(String[] args) {
        Activity activity = new Activity(1);
        for (int i = 0; i < 1; i++) {
            System.out.println("第" + (i + 1) + "次抽奖");
            activity.deduceMoney();
            activity.raffle();
        }
        System.out.println("StatePattern");
    }
}
