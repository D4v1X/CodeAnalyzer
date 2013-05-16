package Analyzer.code.java.metrics;

import Analyzer.code.java.metrics.indicators.CodeLines;
import java.util.ArrayList;
import java.util.List;

public class PackageMetrics extends Metrics {

    private List<PackageMetrics> packageMetricsesList;
    private List<ClassMetrics> classMetricsList;
    private List<HeadMetrics> headCodeMetricsList;

    public PackageMetrics(String name) {
        super(name);
        this.classMetricsList = new ArrayList<>();
        this.headCodeMetricsList = new ArrayList<>();
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

    public Double getNumberClass() {
        return (double) classMetricsList.size();
    }

    public void addMetrics(Metrics metrics) {
        if (metrics instanceof ClassMetrics) {
            addClassMetrics((ClassMetrics) metrics);
        } else if (metrics instanceof HeadMetrics) {
            addHeadCodeMetrics((HeadMetrics) metrics);
        } else if (metrics instanceof PackageMetrics) {
            addPackageMetrics((PackageMetrics) metrics);
        }
    }

    private void addClassMetrics(ClassMetrics classMetrics) {
        classMetricsList.add(classMetrics);
    }

    private void addHeadCodeMetrics(HeadMetrics headCodeMetrics) {
        headCodeMetricsList.add(headCodeMetrics);
    }

    private void addPackageMetrics(PackageMetrics packageMetrics) {
        packageMetricsesList.add(packageMetrics);
    }

    public ClassMetrics[] getClassMetricsList() {
        return classMetricsList.toArray(new ClassMetrics[classMetricsList.size()]);
    }

    public PackageMetrics[] getPackageMetricsList() {
        return packageMetricsesList.toArray(new PackageMetrics[packageMetricsesList.size()]);
    }

    @Override
    public Boolean isClassMetrics() {
        return false;
    }

    @Override
    public Boolean isMethodMetrics() {
        return false;
    }

    @Override
    public Boolean isPackageMetrics() {
        return true;
    }
}
