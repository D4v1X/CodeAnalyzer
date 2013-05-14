package Analyzer.code.java.parse;

import Analyzer.code.java.metrics.ClassMetrics;
import Analyzer.code.java.metrics.MethodMetrics;
import Analyzer.code.java.metrics.Metrics;
import Analyzer.code.java.metrics.calculator.ClassMetricsCalculator;
import Analyzer.code.java.metrics.calculator.MethodMetricsCalculator;
import Analyzer.code.java.metrics.calculator.MetricsCalculator;
import java.util.ArrayList;
import java.util.List;

public class CodeParse {

    private final String[] code;
    private Integer position;
    private List<Metrics> metricsList;
    private List<MetricsCalculator> metricsCalculatorsList;

    public CodeParse(String[] code) {
        this.code = code;
        this.metricsList = new ArrayList<>();
        this.metricsCalculatorsList = new ArrayList<>();
    }

    private String nextLine() {
        String line;
        if (code.length > position) {
            line = code[position];
            position++;
            return line;
        }
        return null;
    }

    private Boolean isClass(String line) {
        return line.contains("class");
    }

    public String getFullNameMethod(String line, String fullNameClass) {
        String delims = "[()]";
        String[] tokens = line.split(delims);
        delims = "[ ]";
        tokens = tokens[0].split(delims);
        return fullNameClass.concat(".").concat(tokens[tokens.length - 1]);
    }

    public String getFullNameClass(String line, String fullNamePackage) {
        return fullNamePackage.concat(".").concat(getSimpleNameClass(line));
    }

    public String getSimpleNameClass(String line) {
        String delims = "[ ]";
        String[] tokens = line.split(delims);
        return tokens[tokens.length - 2];
    }

    public String getFullNamePackage(String line) {
        String delims = "[ ;]";
        String[] tokens = line.split(delims);
        return tokens[1];
    }

    public String getSimpleNamePackage(String line) {
        line = getSimpleNamePackage(line);
        String delims = ".";
        String[] tokens = line.split(delims);
        return tokens[tokens.length - 1];
    }

    public void splitCode() {
        Integer bracesClass, bracesMethod;
        position = 0;
        String line;
        ClassMetrics classMetrics;
        String fullNamePackage = null, fullNameMethod;
        String fullNameClass, simpleNameClass;
        ArrayList<String> pieceofcode = new ArrayList<>();
        ArrayList<String> pieceofcodeMethod = new ArrayList<>();

        while (position < code.length) {
            line = nextLine();

            if (isPackage(line)) {
                fullNamePackage = getFullNamePackage(line);
            }

            if (isClass(line)) {
                bracesClass = 1;
                fullNameClass = getFullNameClass(line, fullNamePackage);
                simpleNameClass = getSimpleNameClass(line);
                classMetrics = new ClassMetrics(fullNameClass);
                pieceofcode.clear();
                pieceofcode.add(line);
                while (bracesClass > 0) {
                    line = nextLine();
                    pieceofcode.add(line);
                    if (line.contains("{")) {
                        bracesClass++;
                    }
                    if (line.contains("}")) {
                        bracesClass--;
                    }

                    if (isMethod(line, simpleNameClass)) {
                        bracesClass--;
                        bracesMethod = 1;
                        fullNameMethod = getFullNameMethod(line, fullNameClass);
                        pieceofcodeMethod.clear();
                        pieceofcodeMethod.add(line);
                        while (bracesMethod > 0) {
                            line = nextLine();
                            pieceofcodeMethod.add(line);
                            if (line.contains("{")) {
                                bracesMethod++;
                            }
                            if (line.contains("}")) {
                                bracesMethod--;
                            }
                        }
                        MethodMetrics methodMetrics = new MethodMetrics(fullNameMethod, pieceofcodeMethod.toArray(new String[pieceofcodeMethod.size()]));
                        classMetrics.addMethodMetrics(methodMetrics);
                    }
                }
                classMetrics.setCodeClass(pieceofcode.toArray(new String[pieceofcode.size()]));
                metricsList.add(classMetrics);
            }
        }
    }

    public void splitCodev2() {
        Integer bracesClass, bracesMethod;
        position = 0;
        String line;
        ClassMetricsCalculator classMetricsCalculator;
        String fullNamePackage = null, fullNameMethod;
        String fullNameClass, simpleNameClass;
        ArrayList<String> pieceofcode = new ArrayList<>();
        ArrayList<String> pieceofcodeMethod = new ArrayList<>();

        while (position < code.length) {
            line = nextLine();

            if (isPackage(line)) {
                fullNamePackage = getFullNamePackage(line);
            }

            if (isClass(line)) {
                bracesClass = 1;
                fullNameClass = getFullNameClass(line, fullNamePackage);
                simpleNameClass = getSimpleNameClass(line);
                classMetricsCalculator = new ClassMetricsCalculator();
                pieceofcode.clear();
                pieceofcode.add(line);
                while (bracesClass > 0) {
                    line = nextLine();
                    pieceofcode.add(line);
                    if (line.contains("{")) {
                        bracesClass++;
                    }
                    if (line.contains("}")) {
                        bracesClass--;
                    }

                    if (isMethod(line, simpleNameClass)) {
                        bracesClass--;
                        bracesMethod = 1;
                        fullNameMethod = getFullNameMethod(line, fullNameClass);
                        pieceofcodeMethod.clear();
                        pieceofcodeMethod.add(line);
                        while (bracesMethod > 0) {
                            line = nextLine();
                            pieceofcodeMethod.add(line);
                            if (line.contains("{")) {
                                bracesMethod++;
                            }
                            if (line.contains("}")) {
                                bracesMethod--;
                            }
                        }
                        MethodMetricsCalculator methodMetricsCalculator = new MethodMetricsCalculator(pieceofcodeMethod.toArray(new String[pieceofcodeMethod.size()]));
                        classMetricsCalculator.addMethod(methodMetricsCalculator);
                    }
                }
                classMetricsCalculator.setCode(pieceofcode.toArray(new String[pieceofcode.size()]));
                metricsCalculatorsList.add(classMetricsCalculator);
            }
        }
    }
//TODO Crear Clase "identify".

    private boolean isPackage(String line) {
        return line.contains("package");
    }

    private boolean isImport(String line) {
        return line.contains("import");
    }

    private boolean isInterface(String line) {
        return line.contains("interface");
    }

    private boolean isMethod(String line, String simpleNameClass) {
        return isFunction(line) && (!line.contains(simpleNameClass));
    }

    private boolean isConstructor(String line, String simpleNameClass) {
        return isFunction(line) && (line.contains(simpleNameClass));
    }

    private boolean isFunction(String line) {
        return (line.contains("private") || line.contains("public") || line.contains("protected")) && (line.contains("("));
    }

    public Integer getMetricsListSize() {
        return metricsList.size();
    }

    public Metrics[] getMetricsList() {
        return metricsList.toArray(new Metrics[metricsList.size()]);
    }

    public Integer getMetricsCalculatorsListSize() {
        return metricsCalculatorsList.size();
    }

    public MetricsCalculator[] getMetricsCalculatorsList() {
        return metricsCalculatorsList.toArray(new MetricsCalculator[metricsCalculatorsList.size()]);
    }
}
