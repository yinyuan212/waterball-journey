package com.waterball.ch3.command;


import com.waterball.ch3.command.command.Command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class MainController {

    private Map<Character, List<Command>> commands = new HashMap<>();
    private Stack<Command> undoStack = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();

    private final Tank tank;
    private final Telecom telecom;

    public MainController(Tank tank, Telecom telecom) {
        this.tank = tank;
        this.telecom = telecom;
    }

    public void pressButton(Character c) {
        List<Command> commandsToExecute = commands.get(c);
        for (Command command : commandsToExecute) {
            command.execute();

            undoStack.push(command);
            redoStack.clear();
        }
    }

    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("nothing to undo");
            return;
        }

        Command command = undoStack.pop();
        command.undo();

        redoStack.push(command);
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("nothing to redo");
            return;
        }

        Command command = redoStack.pop();
        command.execute();

        undoStack.push(command);
    }

    public void setCommands(Character c, List<Command> commandList) {
        commands.put(c, commandList);
    }

    public void resetCommands() {
        commands.clear();
    }

}
