package Analyzer.code.java.metrics.indicators;

public class CodeLines {

    private Double blankLines;
    private Double commentLines;
    private Double effectiveLines;

    public CodeLines() {
        this.blankLines = 0.0;
        this.commentLines = 0.0;
        this.effectiveLines = 0.0;
    }

    public Double getBlankLines() {
        return blankLines;
    }

    public void increaseBlankLines() {
        this.blankLines++;
    }

    public Double getCommentLines() {
        return commentLines;
    }

    public void increaseCommentLines() {
        this.commentLines++;
    }

    public Double getEffectiveLines() {
        return effectiveLines;
    }

    public void increaseEffectiveLines() {
        this.effectiveLines++;
    }

    public Double getAllLines() {
        return effectiveLines + blankLines + commentLines;
    }

    public void addLines(CodeLines codeLines) {
        this.blankLines += codeLines.getBlankLines();
        this.commentLines += codeLines.getCommentLines();
        this.effectiveLines += codeLines.getEffectiveLines();
    }
}
