package ru.fizteh.fivt.students.baldindima.shell;

import java.io.IOException;

public interface ShellCommand {
	void run() throws IOException;
	boolean isItCommand(String[] commands) throws IOException;
	//String getName();
	

}
