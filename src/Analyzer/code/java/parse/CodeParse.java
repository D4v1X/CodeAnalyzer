package Analyzer.code.java.parse;

import Analyzer.code.java.Contains;
import Analyzer.code.java.metrics.ClassMetrics;
import Analyzer.code.java.metrics.HeadMetrics;
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
        if (code.length > position) {
            return code[position++];
        }
        return null;
    }

    public void splitCode() {
        position = 0;
        String line;
        HeadMetrics headMetrics = null;
        Boolean isHead = true;
        while (position < code.length) {
            line = nextLine();
            if (isHead) {
                headMetrics = splitHead();
                metricsList.add(headMetrics);
                line = getCurrentLine();
            }
            if (Contains.Class(line)) {
                isHead = false;
                metricsList.add(splitClass(headMetrics.getNamePackage()));
            }
        }
    }

    public Integer getMetricsListSize() {
        return metricsList.size();
    }

    public Metrics[] getMetricsList() {
        return metricsList.toArray(new Metrics[metricsList.size()]);
    }

    private MethodMetrics splitMethod(String fullNameClass) {
        String line = getCurrentLine();
        String fullNameMethod = getFullNameMethod(line, fullNameClass);
        ArrayList<String> methodCode = new ArrayList<>();
        int bracesMethod = 1;
        methodCode.clear();
        methodCode.add(line);
        while (bracesMethod > 0) {
            line = nextLine();
            methodCode.add(line);
            bracesMethod = manageBraces(line, bracesMethod);
        }
        return new MethodMetrics(fullNameMethod, methodCode.toArray(new String[methodCode.size()]));
    }

    private ClassMetrics splitClass(String fullNamePackage) {
        String line = getCurrentLine();
        ArrayList<String> classCode = new ArrayList<>();
        int bracesClass = 1;
        String fullNameClass = getFullNameClass(line, fullNamePackage);
        ClassMetrics classMetrics = new ClassMetrics(fullNameClass);
        classCode.clear();
        classCode.add(line);
        while (bracesClass > 0) {
            line = nextLine();
            classCode.add(line);
            bracesClass = manageBraces(line, bracesClass);
            if (Contains.Method(line, classMetrics.getSimpleName())) {
                bracesClass--;
                classMetrics.addMethod(splitMethod(fullNameClass));
            }
        }
        classMetrics.setCode(classCode.toArray(new String[classCode.size()]));
        return classMetrics;
    }

    private HeadMetrics splitHead() {
        String line = getCurrentLine();
        ArrayList<String> headCode = new ArrayList<>();
        while (!Contains.Class(line)) {
            headCode.add(line);
            line = nextLine();
        }
        return new HeadMetrics("Head", headCode.toArray(new String[headCode.size()]));
    }

    private String getFullNameMethod(String line, String fullNameClass) {
        String[] tokens = line.split("[()]");
        tokens = tokens[0].split("[ ]");
        return fullNameClass.concat(".").concat(tokens[tokens.length - 1]);
    }

    private String getFullNameClass(String line, String fullNamePackage) {
        return fullNamePackage.concat(".").concat(getSimpleNameClass(line));
    }

    private String getSimpleNameClass(String line) {
        String[] tokens = line.split("[ ]");
        return tokens[tokens.length - 2];
    }

    private String getCurrentLine() {
        return code[position - 1];
    }

    private Integer manageBraces(String line, int bracesClass) {
        if (Contains.openBrace(line)) {
            bracesClass++;
        }
        if (Contains.closeBrace(line)) {
            bracesClass--;
        }
        return bracesClass;
    }
}
