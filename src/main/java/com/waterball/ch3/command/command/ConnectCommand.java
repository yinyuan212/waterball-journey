package com.waterball.ch3.command.command;


import com.waterball.ch3.command.Telecom;

public class ConnectCommand implements Command {

    private final Telecom telecom;

    public ConnectCommand(Telecom telecom) {
        this.telecom = telecom;
    }

    @Override
    public void execute() {
        telecom.connect();
    }

    @Override
    public void undo() {
        telecom.disconnect();
    }
}

