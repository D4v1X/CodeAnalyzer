package Analyzer.code.java.metrics.calculator;

import Analyzer.code.java.metrics.indicators.CodeLines;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MethodMetricsCalculator {

    private final List<String> code;
    private HashMap<Integer, LineType> lineTypeTable;

    public MethodMetricsCalculator(String[] code) {
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

    public Integer getNumberOfParameters() {
        String head = code.get(0);
        String[] tokens = head.split("[()]");
        tokens = tokens[1].split(",");
        if (tokens.length == 1 && tokens[0].isEmpty()) {
            return 0;
        }
        return tokens.length;
    }
    
    public Integer getCyclomaticComplexity(){
        Integer cyclomaticComplexit = 0;
        Integer numberLine = 0;
        for(String line : code){
            numberLine++;
            if(lineTypeTable.get(numberLine) == LineType.EFFECTIVE){
                if(line.contains("if")) cyclomaticComplexit++;
                if(line.contains("else if")) cyclomaticComplexit++;
                if(line.contains("else")) cyclomaticComplexit++;
                if(line.contains("for")) cyclomaticComplexit++;
                if(line.contains("foreach")) cyclomaticComplexit++;
                if(line.contains("while")) cyclomaticComplexit++;
                if(line.contains("case")) cyclomaticComplexit++;
                if(line.contains("default")) cyclomaticComplexit++;
                if(line.contains("continue")) cyclomaticComplexit++;
                if(line.contains("&&")) cyclomaticComplexit++;
                if(line.contains("||")) cyclomaticComplexit++;
                if(line.contains("catch")) cyclomaticComplexit++;
                if(line.contains("?")) cyclomaticComplexit++;
                if(line.contains("return")) cyclomaticComplexit++;
            }

        }
        return cyclomaticComplexit;
    }

    private void increaseCodeLines(CodeLines lines, LineType lineType) {
        if (lineType == LineType.BLANK) {
            lines.increaseBlankLines();
        }
        else if (lineType == LineType.COMMENT) {
            lines.increaseCommentLines();
        }
        else  {
            lines.increaseEffectiveLines();
        }
    }
    
}
