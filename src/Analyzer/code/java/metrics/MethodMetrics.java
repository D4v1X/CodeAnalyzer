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
    
    public Double getNumberOfParameters() {
        String head = code.get(0);
        String[] tokens = head.split("[()]");
        tokens = tokens[1].split(",");
        if (tokens.length == 1 && tokens[0].isEmpty()) {
            return 0.0;
        }
        return (double) tokens.length;
    }

    public Double getCyclomaticComplexity() {
        Integer cyclomaticComplexity = 0;
        Integer numberLine = 0;
        String[] symbolsArray = new String[]{
            "if", "else if", "else", "case",
            "foreach", "while", "for",
            "default", "continue", "catch", "return",
            "||", "&&", "?", "=="
        };
        
        for (String line : code) {
            numberLine++;
            if (lineTypeTable.get(numberLine) == LineType.EFFECTIVE) {
                for (String symbol : symbolsArray) {
                    if (line.contains(symbol)) {
                        cyclomaticComplexity++;
                        break;
                    }
                }
            }
        }        
        return (double) cyclomaticComplexity;
    }
    
    public Boolean isUsed(String attribute) {
        for (String line : code) {
            if (Contains.Atribute(line, attribute)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Boolean isClassMetrics() {
        return false;
    }
    
    @Override
    public Boolean isMethodMetrics() {
        return true;
    }
    
    @Override
    public Boolean isPackageMetrics() {
        return false;
    }
}
