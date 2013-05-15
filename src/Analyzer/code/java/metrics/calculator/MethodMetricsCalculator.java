package Analyzer.code.java.metrics.calculator;

import Analyzer.code.java.Contains;

public class MethodMetricsCalculator extends CodeMetricsCalculator {

    public MethodMetricsCalculator(String[] code) {
        super(code);
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

    public Integer getCyclomaticComplexity() {
        Integer cyclomaticComplexit = 0;
        Integer numberLine = 0;
        String[] symbolsArray = new String[]{"if", "else if", "else", "for",
                                            "foreach", "while", "case", "||",
                                            "default", "continue", "&&",  "?",
                                            "catch", "return"};
        for (String line : code) {
            numberLine++;
            if (lineTypeTable.get(numberLine) == LineType.EFFECTIVE) {
                for (String symbol : symbolsArray) {
                    if (line.contains(symbol)) {
                        cyclomaticComplexit++;
                        break;
                    }
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
