package Analyzer.code;

import Analyzer.code.java.MetricsAnalyzer;
import Analyzer.code.java.metrics.Metrics;
import Analyzer.structure.Directory;
import Analyzer.structure.FileAnalyzer;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Analyzer {

    public static Metrics start(String path) {
        Directory rootDirectory = null;
        try {
            rootDirectory = (Directory) FileAnalyzer.createDirectoryTree(path);
        } catch (IOException ex) {
            Logger.getLogger(Analyzer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return MetricsAnalyzer.createDataMetrics(rootDirectory);
    }
}
