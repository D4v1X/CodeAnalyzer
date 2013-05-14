package Analyzer.code.java.metrics.calculator;

import Analyzer.code.java.metrics.indicators.CodeLines;
import java.util.ArrayList;
import java.util.List;

public class PackageMetricsCalculator extends MetricsCalculator {

    private List<ClassMetricsCalculator> classMetricsList;
    private List<HeadCodeMetricsCalculator> headCodeMetricsList;
    private String name;

    public PackageMetricsCalculator(String name) {
        this.classMetricsList = new ArrayList<>();
        this.headCodeMetricsList = new ArrayList<>();
        this.name = name;
    }

    @Override
    public CodeLines getCodeLines() {
        CodeLines packageLines = new CodeLines();
        for (ClassMetricsCalculator classMetricsCalculator : classMetricsList) {
            packageLines.addLines(classMetricsCalculator.getCodeLines());
        }
        for (HeadCodeMetricsCalculator headCodeMetricsCalculator : headCodeMetricsList) {
            packageLines.addLines(headCodeMetricsCalculator.getCodeLines());
        }
        return packageLines;
    }

    public Integer getNumberClass() {
        return classMetricsList.size();
    }
}
