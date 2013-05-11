package Analyzer.code.java.metrics;

import Analyzer.code.java.metrics.indicators.Coupling;
import java.util.ArrayList;
import java.util.List;

public class PackageMetrics extends Metrics {

    private List<ClassMetrics> classMetricsList;
    private List<HeadCodeMetrics> headCodeMetricsList;
    private Integer couplingLibrary;
    private Coupling coupling;

    public PackageMetrics(String name) {
        super(name);
        this.classMetricsList = new ArrayList<>();
        this.coupling = new Coupling();
    }

    public ClassMetrics[] getClassMetricsList() {
        return classMetricsList.toArray(new ClassMetrics[classMetricsList.size()]);
    }

    public Integer getClassMetricsNumber() {
        return classMetricsList.size();
    }

    public HeadCodeMetrics[] getHeadCodeMetricsList() {
        return headCodeMetricsList.toArray(new HeadCodeMetrics[headCodeMetricsList.size()]);
    }

    public Integer getHeadCodeMetricsNumber() {
        return headCodeMetricsList.size();
    }

    @Override
    public Integer getTotalCodeLines() {
        Integer totalCodeLines = 0;
        for (ClassMetrics Class : getClassMetricsList()) {
            totalCodeLines += Class.getTotalCodeLines();
        }
        for (HeadCodeMetrics headCode : getHeadCodeMetricsList()) {
            totalCodeLines += headCode.getTotalCodeLines();
        }
        return totalCodeLines;
    }

    void addMetrics(Metrics metrics) {
        if (metrics instanceof ClassMetrics) {
            addClassMetrics((ClassMetrics) metrics);
        } else if (metrics instanceof HeadCodeMetrics) {
            addHeadCodeMetrics((HeadCodeMetrics) metrics);
        }
    }

    private void addClassMetrics(ClassMetrics myClass) {
        classMetricsList.add(myClass);
    }

    private void addHeadCodeMetrics(HeadCodeMetrics headCodeMetrics) {
        headCodeMetricsList.add(headCodeMetrics);
    }
}
