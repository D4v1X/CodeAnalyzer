package Analyzer.code.java.metrics;

import Analyzer.code.LineType;
import Analyzer.code.java.Contains;
import java.util.ArrayList;
import java.util.List;

public class ClassMetrics extends CodeMetrics {

    private List<MethodMetrics> methodMetricsList;
    private List<String> attributeList;

    public ClassMetrics(String name) {
        super(name);
        methodMetricsList = new ArrayList<>();
        attributeList = new ArrayList<>();
    }

    public ClassMetrics(String name, String[] code) {
        super(name, code);
        methodMetricsList = new ArrayList<>();
        attributeList = new ArrayList<>();
    }

    public void addMethod(MethodMetrics method) {
        methodMetricsList.add(method);
    }

    public Integer getNumberOfMethod() {
        return methodMetricsList.size();
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
        for (MethodMetrics method : methodMetricsList) {
            for (String attribute : attributeList) {
                if (method.isUsed(attribute)) {
                    total++;
                }
            }
        }
        return total;
    }

    public MethodMetrics[] getMethodMetricsList() {
        return methodMetricsList.toArray(new MethodMetrics[methodMetricsList.size()]);
    }

    public Integer getMethodMetricsListSize() {
        return methodMetricsList.size();
    }
    //TODO Cread metrica de Dependencias
    //Nota HashTable for Eferente(num import) (nombre de clase, numero de repeticiones)
    //                   Aferente consultar Hashmap
}
