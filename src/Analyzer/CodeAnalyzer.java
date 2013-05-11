package Analyzer;

import Analyzer.code.java.Analyzer;

public class CodeAnalyzer {

    public static void main(String[] args) {
        Analyzer analyzer = new Analyzer(args[0]);
        analyzer.start();
        //SaveMetrics saveMetrics = new SaveMetrics("Pendiente de Esctructura");
        //saveMetrics.start();
    }
}
