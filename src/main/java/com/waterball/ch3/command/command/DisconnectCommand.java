package com.waterball.ch3.command.command;


import com.waterball.ch3.command.Telecom;

public class DisconnectCommand implements Command {

    private final Telecom telecom;

    public DisconnectCommand(Telecom telecom) {
        this.telecom = telecom;
    }

    @Override
    public void execute() {
        telecom.disconnect();
    }

    @Override
    public void undo() {
        telecom.connect();
    }
}

