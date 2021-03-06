package ru.fizteh.fivt.students.belousova.filemap;

import ru.fizteh.fivt.storage.strings.Table;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SingleFileTable implements Table {
    private Map<String, String> dataBase = new HashMap<String, String>();
    private File dataFile;

    public SingleFileTable(File data) throws IOException {
        if (!data.exists()) {
            throw new IOException("file doesn't exist");
        } else {
            dataFile = data;
            FileMapUtils.read(dataFile, dataBase);
        }
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String get(String key) {
        return dataBase.get(key);
    }

    @Override
    public String put(String key, String value) {
        return dataBase.put(key, value);
    }

    @Override
    public String remove(String key) {
        return dataBase.remove(key);
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("this operation is not supported");
    }

    @Override
    public int commit() {
        try {
            FileMapUtils.write(dataFile, dataBase);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public int rollback() {
        throw new UnsupportedOperationException("this operation is not supported");
    }
}
