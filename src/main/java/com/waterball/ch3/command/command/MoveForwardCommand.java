package com.waterball.ch3.command.command;

import com.waterball.ch3.command.Tank;

public class MoveForwardCommand implements Command {

    private final Tank tank;

    public MoveForwardCommand(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void execute() {
        tank.moveForward();
    }

    @Override
    public void undo() {
        tank.moveBackward();
    }
}
