package ru.fizteh.fivt.students.nadezhdakaratsapova.shell;

import java.io.File;

public class CurrentDirectory {
    private File curDir;

    File getCurDir() {
        return curDir;
    }

    File changeCurDir(File newDir) {
        curDir = newDir;
        return curDir;
    }
}
