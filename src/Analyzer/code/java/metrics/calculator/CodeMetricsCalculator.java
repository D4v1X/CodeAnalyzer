package Analyzer.code.java.metrics.calculator;

import Analyzer.code.java.metrics.indicators.CodeLines;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CodeMetricsCalculator extends MetricsCalculator {

    protected List<String> code;
    protected HashMap<Integer, LineType> lineTypeTable;

    public CodeMetricsCalculator() {
        this.lineTypeTable = new HashMap<>();
    }

    public CodeMetricsCalculator(String[] code) {
        this.code = new ArrayList<>(Arrays.asList(code));
        this.lineTypeTable = new HashMap<>();
        initLineTypeTable();
    }

    private void initLineTypeTable() {
        boolean iAmCommment = false;
        Integer numberLine = 0;
        for (String line : code) {
            numberLine++;
            if (line.contains("//") && !iAmCommment) {
                lineTypeTable.put(numberLine, LineType.COMMENT);
            } else if (line.contains("/*") && !iAmCommment) {
                lineTypeTable.put(numberLine, LineType.COMMENT);
                if (!line.contains("*/")) {
                    iAmCommment = true;
                }
            } else if (iAmCommment) {
                lineTypeTable.put(numberLine, LineType.COMMENT);
                if (line.contains("*/")) {
                    iAmCommment = false;
                }
            } else if (line.isEmpty()) {
                lineTypeTable.put(numberLine, LineType.BLANK);
            } else {
                lineTypeTable.put(numberLine, LineType.EFFECTIVE);
            }
        }
    }

    public CodeLines getCodeLines() {
        CodeLines lines = new CodeLines();
        for (int i = 1; i <= code.size(); i++) {
            increaseCodeLines(lines, lineTypeTable.get(i));
        }
        return lines;
    }

    private void increaseCodeLines(CodeLines lines, LineType lineType) {
        if (lineType == LineType.BLANK) {
            lines.increaseBlankLines();
        } else if (lineType == LineType.COMMENT) {
            lines.increaseCommentLines();
        } else {
            lines.increaseEffectiveLines();
        }
    }

    public void setCode(String[] codeArray) {
        code = new ArrayList<>(Arrays.asList(codeArray));
        initLineTypeTable();
    }
}
