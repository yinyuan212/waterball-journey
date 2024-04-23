package com.waterball.ch3.command;



import com.waterball.ch3.command.command.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static List<Command> commandList;


    public static void main(String[] args) {
        Tank tank = new Tank();
        Telecom telecom = new Telecom();

        MainController mainController = new MainController(tank, telecom);

        commandList = Arrays.asList(
                new MoveForwardCommand(tank),
                new MoveBackwardCommand(tank),
                new ConnectCommand(telecom),
                new DisconnectCommand(telecom));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("press a button: 1 - set commands, 2 - undo, 3 - redo, r - reset, other - execute");

            String line = scanner.nextLine();

            if ("1".equals(line)) {
                setCommands(mainController);
            } else if ("2".equals(line)) {
                mainController.undo();
            } else if ("3".equals(line)) {
                mainController.redo();
            } else if ("r".equals(line)) {
                mainController.resetCommands();
            } else {
                mainController.pressButton(line.charAt(0));
            }
        }
    }

    private static void setCommands(MainController mainController) {
        System.out.println("set marco? y/n");

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        if ("y".equals(line)) {
            System.out.println("choose a key");
            String key = scanner.nextLine();

            System.out.println("choose commands");
            for (int i = 0; i < commandList.size(); i++) {
                Command command = commandList.get(i);
                System.out.println(String.format("%d - %s", i, command.toString()));
            }

            line = scanner.nextLine();

            List<Command> commands = Arrays.stream(line.split(" "))
                                    .mapToInt(Integer::parseInt)
                                    .mapToObj(commandList::get)
                                    .collect(Collectors.toList());


            mainController.setCommands(key.charAt(0), commands);
            System.out.println(String.format("set key : %s - commands :", key));
            commands.forEach(System.out::println);

        } else if("n".equals(line)) {
            System.out.println("choose a key");

            String key = scanner.nextLine();
            System.out.println("choose a command");
            for (int i = 0; i < commandList.size(); i++) {
                Command command = commandList.get(i);
                System.out.println(String.format("%d - %s", i, command.toString()));
            }

            int index = scanner.nextInt();
            Command command = commandList.get(index);
            mainController.setCommands(key.charAt(0), Arrays.asList(command));
            System.out.println(String.format("set key : %s - command : %s", key, command));
        }

    }
}
