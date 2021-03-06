package ru.fizteh.fivt.students.adanilyak.commands;

import ru.fizteh.fivt.students.adanilyak.modernfilemap.FileMapState;

import java.io.IOException;
import java.util.List;

/**
 * User: Alexander
 * Date: 21.10.13
 * Time: 14:18
 */
public class CmdGet implements Cmd {
    private final String name = "get";
    private final int amArgs = 1;
    private FileMapState workState;

    public CmdGet(FileMapState dataBaseState) {
        workState = dataBaseState;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAmArgs() {
        return amArgs;
    }

    @Override
    public void work(List<String> args) throws IOException {
        if (workState.currentTable != null) {
            String key = args.get(1);
            String result = workState.get(key);
            if (result == null) {
                System.out.println("not found");
            } else {
                System.out.println("found");
                System.out.println(result);
            }
        } else {
            System.out.println("no table");
        }
    }
}
