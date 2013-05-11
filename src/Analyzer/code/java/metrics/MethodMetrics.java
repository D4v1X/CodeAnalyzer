package Analyzer.code.java.metrics;

public class MethodMetrics extends Metrics {

    private Integer cyclomaticComplexity;
    private Integer parametersNumber;
    private String[] codeMethod;

    public MethodMetrics(String name) {
        super(name);
    }

    public MethodMetrics(String nameClass, String[] codeMethod) {
        this(nameClass);
        this.codeMethod = codeMethod;
    }

    public void setCyclomaticComplexity(Integer cyclomaticComplexity) {
        this.cyclomaticComplexity = cyclomaticComplexity;
    }

    public Integer getCyclomaticComplexity() {
        return cyclomaticComplexity;
    }

    public void setParemetersNumber(Integer parametersNumber) {
        this.parametersNumber = parametersNumber;
    }

    public Integer getParametersNumber() {
        return parametersNumber;
    }

    public String[] getCodeMethod() {
        return codeMethod;
    }
}
