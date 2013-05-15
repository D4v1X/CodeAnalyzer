package Analyzer.code.java.metrics;

import Analyzer.code.LineType;
import Analyzer.code.java.Contains;

public class MethodMetrics extends CodeMetrics {

    public MethodMetrics(String name) {
        super(name);
    }

    public MethodMetrics(String name, String[] code) {
        super(name, code);
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
//TODO Fix if

    public Integer getCyclomaticComplexity() {
        Integer cyclomaticComplexit = 0;
        Integer numberLine = 0;
        for (String line : code) {
            numberLine++;
            if (lineTypeTable.get(numberLine) == LineType.EFFECTIVE) {
                if (line.contains("if")) {
                    cyclomaticComplexit++;
                }
                if (line.contains("else if")) {
                    cyclomaticComplexit++;
                }
                if (line.contains("else")) {
                    cyclomaticComplexit++;
                }
                if (line.contains("for")) {
                    cyclomaticComplexit++;
                }
                if (line.contains("foreach")) {
                    cyclomaticComplexit++;
                }
                if (line.contains("while")) {
                    cyclomaticComplexit++;
                }
                if (line.contains("case")) {
                    cyclomaticComplexit++;
                }
                if (line.contains("default")) {
                    cyclomaticComplexit++;
                }
                if (line.contains("continue")) {
                    cyclomaticComplexit++;
                }
                if (line.contains("&&")) {
                    cyclomaticComplexit++;
                }
                if (line.contains("||")) {
                    cyclomaticComplexit++;
                }
                if (line.contains("catch")) {
                    cyclomaticComplexit++;
                }
                if (line.contains("?")) {
                    cyclomaticComplexit++;
                }
                if (line.contains("return")) {
                    cyclomaticComplexit++;
                }
            }

        }
        return cyclomaticComplexit;
    }

    public Boolean isUsed(String attribute) {
        for (String line : code) {
            if (Contains.Atribute(line, attribute)) {
                return true;
            }
        }
        return false;
    }
}
