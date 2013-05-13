package Analyzer.code.java.metrics.calculator;

import Analyzer.code.java.Contains;
import java.util.ArrayList;
import java.util.List;

public class ClassMetricsCalculator extends CodeMetricsCalculator {

    private List<MethodMetricsCalculator> methodMetricsCalculatorList;
    private List<String> attributeList;

    public ClassMetricsCalculator(String[] code) {
        super(code);
        methodMetricsCalculatorList = new ArrayList<>();
        attributeList = new ArrayList<>();
    }

    public void addMethod(MethodMetricsCalculator method) {
        methodMetricsCalculatorList.add(method);
    }

    public Integer getNumberOfMethod() {
        return methodMetricsCalculatorList.size();
    }

    public Integer getNumberOfAttribute() {
        Boolean inAttributeZone = false;
        Integer numberOfLine = 0;
        for (String line : code) {
            numberOfLine++;
            if (Contains.Class(line) && !inAttributeZone) {
                inAttributeZone = true;
            } else if (Contains.Function(line) && inAttributeZone) {
                inAttributeZone = false;
            } else if (inAttributeZone
                    && LineType.EFFECTIVE == lineTypeTable.get(numberOfLine)
                    && Contains.SemiColon(line)) {
                String[] tokens = line.split("[ ;]");
                attributeList.add(tokens[tokens.length - 1]);
            }
        }
        return attributeList.size();
    }
    
    
}
