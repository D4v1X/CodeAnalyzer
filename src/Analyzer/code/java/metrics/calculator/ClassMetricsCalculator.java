package Analyzer.code.java.metrics.calculator;

import Analyzer.code.LineType;
import Analyzer.code.java.Contains;
import java.util.ArrayList;
import java.util.List;

public class ClassMetricsCalculator extends CodeMetricsCalculator {

    private List<MethodMetricsCalculator> methodMetricsCalculatorList;
    private List<String> attributeList;

    public ClassMetricsCalculator() {
        methodMetricsCalculatorList = new ArrayList<>();
        attributeList = new ArrayList<>();
    }

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

    public Double getLackOfCohesion() {
        return calculateLOCM();
    }

    private Double calculateLOCM() {
        Integer F = getNumberOfAttribute();
        Integer M = getNumberOfMethod();
        return 1 - (getSummationMF() / (M * F));
    }

    private Double getSummationMF() {
        Double total = 0.0;
        for (MethodMetricsCalculator method : methodMetricsCalculatorList) {
            for (String attribute : attributeList) {
                if (method.isUsed(attribute)) {
                    total++;
                }
            }
        }
        return total;
    }
    //TODO Cread metrica de Dependencias
    //Nota HashTable for Eferente(num import) (nombre de clase, numero de repeticiones)
    //                   Aferente consultar Hashmap
}
