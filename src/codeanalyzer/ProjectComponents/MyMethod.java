package codeanalyzer.ProjectComponents;

import codeanalyzer.ProjectComponents.MetricClass.CodeLines;

public class MyMethod {
    private String name;
    private Integer cyclomaticComplexity;
    private Integer parameters;
    private CodeLines codeLines;

    public void setCyclomaticComplexity(Integer cyclomaticComplexity) {
        this.cyclomaticComplexity = cyclomaticComplexity;
    }

    public Integer getCyclomaticComplexity() {
        return cyclomaticComplexity;
    }
    
}
