package Analyzer.code.java.metrics;

import Analyzer.code.java.metrics.indicators.CodeLines;
import java.util.ArrayList;
import java.util.List;

public class PackageMetrics extends Metrics {

    private List<ClassMetrics> classMetricsList;
    private List<HeadMetrics> headCodeMetricsList;
    private String name;

    public PackageMetrics(String name) {
        this.classMetricsList = new ArrayList<>();
        this.headCodeMetricsList = new ArrayList<>();
        this.name = name;
    }

    @Override
    public CodeLines getCodeLines() {
        CodeLines packageLines = new CodeLines();
        for (ClassMetrics classMetrics : classMetricsList) {
            packageLines.addLines(classMetrics.getCodeLines());
        }
        for (HeadMetrics headCodeMetrics : headCodeMetricsList) {
            packageLines.addLines(headCodeMetrics.getCodeLines());
        }
        return packageLines;
    }

    public Integer getNumberClass() {
        return classMetricsList.size();
    }

    public void addMetrics(Metrics metrics) {
        if (metrics instanceof ClassMetrics) {
            addClassMetrics((ClassMetrics) metrics);
        } else if (metrics instanceof HeadMetrics) {
            addHeadCodeMetrics((HeadMetrics) metrics);
        }
    }

    private void addClassMetrics(ClassMetrics classMetrics) {
        classMetricsList.add(classMetrics);
    }

    private void addHeadCodeMetrics(HeadMetrics headCodeMetrics) {
        headCodeMetricsList.add(headCodeMetrics);
    }
}
