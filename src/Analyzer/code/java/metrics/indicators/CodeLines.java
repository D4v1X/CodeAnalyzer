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

    public void setBlankLines(Integer blankLines) {
        this.blankLines = blankLines;
    }

    public Integer getCommentLines() {
        return commentLines;
    }

    public void setCommentLines(Integer commentLines) {
        this.commentLines = commentLines;
    }

    public Integer getEffectiveLines() {
        return effectiveLines;
    }

    public void setEffectiveLines(Integer effectiveLines) {
        this.effectiveLines = effectiveLines;
    }
}
