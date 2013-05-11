package Analyzer.code.java.metrics;

import Analyzer.code.java.metrics.indicators.CodeLines;

public abstract class Metrics {

    private String name;
    private CodeLines codeLines;

    public Metrics(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getEffectiveCodeLines() {
        return codeLines.getEffectiveLines();
    }

    public Integer getBlankCodeLines() {
        return codeLines.getBlankLines();
    }

    public Integer getCommentCodeLines() {
        return codeLines.getCommentLines();
    }

    public void setCodeLines(Integer effectiveLines, Integer blankLines, Integer commentLines) {
        codeLines.setBlankLines(blankLines);
        codeLines.setCommentLines(commentLines);
        codeLines.setEffectiveLines(effectiveLines);
    }

    public Integer getTotalCodeLines() {
        return codeLines.getBlankLines() + codeLines.getCommentLines() + codeLines.getEffectiveLines();
    }
    //public abstract void calculate();
    //public abstract void saveCube();
}
