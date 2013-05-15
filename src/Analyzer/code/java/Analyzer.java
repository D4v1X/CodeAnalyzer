package Analyzer.code.java;

import Analyzer.code.java.metrics.MetricsAnalyzer;
import Analyzer.code.java.metrics.calculator.Metrics;
import Analyzer.structure.Directory;
import Analyzer.structure.FileAnalyzer;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Analyzer {

    private final String path;

    public Analyzer(String javaText) {
        this.path = javaText;
    }

    public void start() {
        try {
            //TODO Estructura
            Directory rootDirectory = (Directory) FileAnalyzer.createDirectoryTree(path);
            //TODO Repartidor de trabajao - ControllerParse(fichero, array)
            Metrics rootMetrics = MetricsAnalyzer.createDirectoryTree(rootDirectory);
            //Devolver lo guardado en memoria.
            //rootMetrics.calculate();
            //Devolver lo guardado en memoria.
            //rootMetrics.saveCube();
        } catch (IOException ex) {
            Logger.getLogger(Analyzer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
