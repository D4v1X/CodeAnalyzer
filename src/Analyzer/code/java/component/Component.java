package Analyzer.code.java.component;

import Analyzer.code.java.metrics.CodeLines;

public abstract class Component {

    private String name;
    private CodeLines codeLines;

    public Component(String name) {
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
}
