package Analyzer;

import Analyzer.code.Analyzer;
import Analyzer.code.java.metrics.PackageMetrics;
import Analyzer.save.SaverMetricsDataStore;
import java.io.File;
import org.codemetric.DataStoreFactory;
import org.sumus.dwh.datastore.DataStore;
import org.sumus.dwh.datastore.DataStoreException;

public class CodeAnalyzer {

    public static void main(String[] args) throws DataStoreException {
        checkArgs(args);
        DataStore dataStore = createDataStore(new File(args[1]));
        SaverMetricsDataStore saverMetricsDataStore = new SaverMetricsDataStore(dataStore);
        saverMetricsDataStore.save((PackageMetrics) Analyzer.start(args[1]));
    }

    private static DataStore createDataStore(File folder) {
        DataStoreFactory factory = new DataStoreFactory(folder);
        DataStore dataStore = factory.createDataStore();
        return dataStore;
    }

    private static void checkArgs(String[] args) {
        checkIsNotNull(args);
        checkSourceExists(new File(args[0]));
        checkTargetNotExists(new File(args[1]));
    }

    private static void checkSourceExists(File sourceDirectory) {
        if (!sourceDirectory.exists()) {
            throw new RuntimeException("Source path does not exist");
        }
    }

    private static void checkTargetNotExists(File targetDirectory) {
        if (targetDirectory.exists()) {
            throw new RuntimeException("Target path does not exist");
        }
    }

    private static void checkIsNotNull(String[] args) {
        if (args[0] == null || args[1] == null) {
            throw new RuntimeException("Paths not introduced");
        }
    }
}
