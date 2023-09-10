package com.haotu.designpattern.behavioral.patterns.command;

/**
 * 命令模式
 */
interface Command {
    void execute();

    void undo();
}

class NoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("空命令");
    }

    @Override
    public void undo() {
        System.out.println("空命令");
    }
}

class AirConditioner {
    public void cool() {
        System.out.println("空调制冷");
    }

    public void stop() {
        System.out.println("空调停止");
    }

    public void heat() {
        System.out.println("空调制热");
    }
}

class HeatCommand implements Command {
    private AirConditioner airConditioner;

    public HeatCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.heat();
    }

    @Override
    public void undo() {
        airConditioner.stop();
    }

}

class RemoteController {
    Command[] Commands;

    public RemoteController() {
        Commands = new Command[5];
        for (int i = 0; i < Commands.length; i++) {
            Commands[i] = new NoCommand();
        }
    }

    public void setCommand(int index, Command command) {
        Commands[index] = command;
    }

    public void heatButtonWasPressed(int index) {
        Commands[index].execute();
    }

    public void undoButtonWasPressed(int index) {
        Commands[index].undo();

    }
}

public class CommandPattern {
    public static void main(String[] args) {
        RemoteController remoteController = new RemoteController();
        AirConditioner airConditioner = new AirConditioner();
        remoteController.setCommand(0, new HeatCommand(airConditioner));
        remoteController.heatButtonWasPressed(0);
        remoteController.undoButtonWasPressed(0);
    }
}
