package com.waterball.ch3.command.command;


import com.waterball.ch3.command.Tank;

public class MoveBackwardCommand implements Command {

    private final Tank tank;

    public MoveBackwardCommand(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void execute() {
        tank.moveBackward();
    }

    @Override
    public void undo() {
        tank.moveForward();
    }
}

