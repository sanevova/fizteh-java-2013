package ru.fizteh.fivt.students.fedoseev.shell;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class ShellInteractiveMode extends AbstractShell {
    public ShellInteractiveMode(File dir) {
        super(dir);
    }

    public void run() throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        while (!Thread.currentThread().isInterrupted()) {
            Thread.currentThread().sleep(10);
            System.out.print(state.getCurState().toString() + "$ ");

            String[] input = scanner.nextLine().trim().split("\\s*;\\s*");

            for (String cmd : input) {
                cmd = cmd.trim();

                int end;
                if ((end = cmd.indexOf(" ")) == -1) {
                    end = cmd.length();
                }

                try {
                    if (cmd.substring(0, end).length() == 0) {
                        continue;
                    }

                    runCommands(cmd, end);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
}