package Analyzer.code.java.parse;

import Analyzer.code.java.Contains;
import Analyzer.code.java.metrics.ClassMetrics;
import Analyzer.code.java.metrics.HeadCodeMetrics;
import Analyzer.code.java.metrics.MethodMetrics;
import Analyzer.code.java.metrics.Metrics;
import java.util.ArrayList;
import java.util.List;

public class CodeParse {

    private final String[] code;
    private Integer position;
    private List<Metrics> metricsList;

    public CodeParse(String[] code) {
        this.code = code;
        this.metricsList = new ArrayList<>();
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
        ClassMetrics classMetricsCalculator;
        HeadCodeMetrics headCodeMetricsCalculator;
        String fullNamePackage = null, fullNameMethod;
        String fullNameClass, simpleNameClass;
        ArrayList<String> headCode = new ArrayList<>();
        ArrayList<String> pieceofcode = new ArrayList<>();
        ArrayList<String> pieceofcodeMethod = new ArrayList<>();
        Boolean isHead = true;
        while (position < code.length) {
            line = nextLine();
            if (Contains.Package(line)) {
                fullNamePackage = getFullNamePackage(line);
            }
            if (isHead) {
                headCode.add(line);
            }
            if (Contains.Class(line)) {
                isHead = false;
                headCodeMetricsCalculator = new HeadCodeMetrics(headCode.toArray(new String[headCode.size()]));
                bracesClass = 1;
                fullNameClass = getFullNameClass(line, fullNamePackage);
                simpleNameClass = getSimpleNameClass(line);
                classMetricsCalculator = new ClassMetrics();
                pieceofcode.clear();
                pieceofcode.add(line);
                while (bracesClass > 0) {
                    line = nextLine();
                    pieceofcode.add(line);
                    if (Contains.openBrace(line)) {
                        bracesClass++;
                    }
                    if (Contains.closeBrace(line)) {
                        bracesClass--;
                    }
                    if (Contains.Method(line, simpleNameClass)) {
                        bracesClass--;
                        bracesMethod = 1;
                        fullNameMethod = getFullNameMethod(line, fullNameClass);
                        pieceofcodeMethod.clear();
                        pieceofcodeMethod.add(line);
                        while (bracesMethod > 0) {
                            line = nextLine();
                            pieceofcodeMethod.add(line);
                            if (Contains.openBrace(line)) {
                                bracesMethod++;
                            }
                            if (Contains.closeBrace(line)) {
                                bracesMethod--;
                            }
                        }
                        MethodMetrics methodMetricsCalculator = new MethodMetrics(pieceofcodeMethod.toArray(new String[pieceofcodeMethod.size()]));
                        classMetricsCalculator.addMethod(methodMetricsCalculator);
                    }
                }
                classMetricsCalculator.setCode(pieceofcode.toArray(new String[pieceofcode.size()]));
                metricsList.add(headCodeMetricsCalculator);
                metricsList.add(classMetricsCalculator);
            }
        }
    }

    public Integer getMetricsListSize() {
        return metricsList.size();
    }

    public Metrics[] getMetricsList() {
        return metricsList.toArray(new Metrics[metricsList.size()]);
    }
}
