package ru.fizteh.fivt.students.ermolenko.MultiFileHashMap;

import ru.fizteh.fivt.storage.strings.TableProvider;
import ru.fizteh.fivt.storage.strings.TableProviderFactory;

import java.io.File;
import java.io.IOException;

public class MFHMTableProviderFactory implements TableProviderFactory {

    @Override
    public TableProvider create(String dir) throws IOException {
        return new MFHMTableProvider(new File(dir));
    }
}
