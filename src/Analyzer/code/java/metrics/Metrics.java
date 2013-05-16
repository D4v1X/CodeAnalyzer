package Analyzer.code.java.metrics;

import Analyzer.code.java.metrics.indicators.CodeLines;

public abstract class Metrics {

    private String name;

    public Metrics(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSimpleName() {
        String[] tokens = name.split("[.]");
        return tokens[tokens.length - 1];
    }

    public abstract CodeLines getCodeLines();

    public abstract Boolean isClassMetrics();

    public abstract Boolean isMethodMetrics();

    public abstract Boolean isPackageMetrics();
}
