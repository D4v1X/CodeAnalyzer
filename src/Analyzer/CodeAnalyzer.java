package Analyzer;

import Analyzer.code.Analyzer;
import java.io.File;
import org.codemetric.DataStoreFactory;
//import org.sumus.dwh.datastore.DataStore;

public class CodeAnalyzer {

    public static void main(String[] args) {
        Analyzer analyzer = new Analyzer(args[0]);
        analyzer.start();
        DataStoreFactory dataStoreFactory = new DataStoreFactory(new File(args[0]));
        //DataStore createDataStore = dataStoreFactory.createDataStore();
        //SaveMetrics saveMetrics = new SaveMetrics("Pendiente de Esctructura");
        //saveMetrics.start();
    }
}
