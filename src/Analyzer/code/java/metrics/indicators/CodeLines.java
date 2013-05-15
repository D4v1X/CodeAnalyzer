package Analyzer.code.java.metrics.indicators;

public class CodeLines {

    private Integer blankLines;
    private Integer commentLines;
    private Integer effectiveLines;

    public CodeLines() {
        this.blankLines = 0;
        this.commentLines = 0;
        this.effectiveLines = 0;
    }

    public Integer getBlankLines() {
        return blankLines;
    }

    public void increaseBlankLines() {
        this.blankLines++;
    }

    public Integer getCommentLines() {
        return commentLines;
    }

    public void increaseCommentLines() {
        this.commentLines++;
    }

    public Integer getEffectiveLines() {
        return effectiveLines;
    }

    public void increaseEffectiveLines() {
        this.effectiveLines++;
    }

    public Integer getAllLines() {
        return effectiveLines + blankLines + commentLines;
    }

    public void addLines(CodeLines codeLines) {
        this.blankLines += codeLines.getBlankLines();
        this.commentLines += codeLines.getCommentLines();
        this.effectiveLines += codeLines.getEffectiveLines();
    }
}
