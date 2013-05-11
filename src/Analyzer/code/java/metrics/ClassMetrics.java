package Analyzer.code.java.metrics;

import Analyzer.code.java.metrics.indicators.Coupling;
import java.util.ArrayList;
import java.util.List;

public class ClassMetrics extends Metrics {

    private Integer numberAttributes;
    private Coupling coupling;
    private List<MethodMetrics> methodMetricsList;
    private String[] codeClass;

    public ClassMetrics(String name) {
        super(name);
        this.numberAttributes = 0;
        this.methodMetricsList = new ArrayList<>();
        this.coupling = new Coupling();
    }

    public ClassMetrics(String nameClass, String[] codeClass) {
        this(nameClass);
        this.codeClass = codeClass;
    }

    public Integer getNumberAttributes() {
        return numberAttributes;
    }

    public void increaseNumberAttributes() {
        this.numberAttributes++;
    }

    public MethodMetrics[] getMethodMetricsList() {
        return methodMetricsList.toArray(new MethodMetrics[methodMetricsList.size()]);
    }

    public Integer getAfferentCoupling() {
        return coupling.getAfferentCoupling();
    }

    public void setAfferentCoupling(Integer afferentCoupling) {
        coupling.setAfferentCoupling(afferentCoupling);
    }

    public Integer getEfferentCoupling() {
        return coupling.getEfferentCoupling();
    }

    public void setEfferentCoupling(Integer efferentCoupling) {
        coupling.setEfferentCoupling(efferentCoupling);
    }

    public String[] getCodeClass() {
        return codeClass;
    }

    public void setCodeClass(String[] codeClass) {
        this.codeClass = codeClass;
    }

    public void addMethodMetrics(MethodMetrics methodMetrics) {
        this.methodMetricsList.add(methodMetrics);
    }

    public Integer getMethodMetricsListSize() {
        return methodMetricsList.size();
    }
}
