package Analyzer.code.java.metrics.calculator;

import Analyzer.code.FileLoader;
import Analyzer.code.java.metrics.ClassMetrics;
import Analyzer.code.java.metrics.MethodMetrics;
import Analyzer.code.java.metrics.Metrics;
import Analyzer.code.java.parse.CodeParse;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class MethodMetricsCalculatorTest {

    MethodMetricsCalculator codeTest;
    List<MethodMetrics> codeTestList;

    public MethodMetricsCalculatorTest() {
        FileLoader fileLoader = new FileLoader("." + File.separator + "test" + File.separator + "TestFiles" + File.separator + "CodeFile3.java");
        codeTest = new MethodMetricsCalculator(fileLoader.toArray());
    }

    public void initM() {
        FileLoader fileLoader = new FileLoader("." + File.separator + "test" + File.separator + "TestFiles" + File.separator + "CodeFile0.java");
        codeTestList = new ArrayList<>();
        CodeParse codeParse = new CodeParse(fileLoader.toArray());
        codeParse.splitCode();
        Metrics[] metrics = codeParse.getMetricsList();
        for (Metrics m : metrics) {
            if (m instanceof ClassMetrics) {
                codeTestList = new ArrayList<>(Arrays.asList(((ClassMetrics) m).getMethodMetricsList()));
            }
        }

    }

    @Test
    public void testGetCodeLinesComment() {
        assertEquals(8, codeTest.getCodeLines().getCommentLines(), 0);
    }

    @Test
    public void testGetCodeLinesBlank() {
        assertEquals(1, codeTest.getCodeLines().getBlankLines(), 0);
    }

    @Test
    public void testGetCodeLineseffective() {
        assertEquals(3, codeTest.getCodeLines().getEffectiveLines(), 0);
    }

    @Test
    public void testGetNumberOfParametersEmpty() {
        initM();
        assertEquals(0, new MethodMetricsCalculator(codeTestList.get(0).getCodeMethod()).getNumberOfParameters(), 0);
    }

    @Test
    public void testGetNumberOfParametersNonEmpty() {
        initM();
        assertEquals(1, new MethodMetricsCalculator(codeTestList.get(1).getCodeMethod()).getNumberOfParameters(), 0);
    }

    @Test
    public void testGetNumberOfParametersNonEmptyTwo() {
        initM();
        assertEquals(2, new MethodMetricsCalculator(codeTestList.get(2).getCodeMethod()).getNumberOfParameters(), 0);
    }

    @Test
    public void testGetCyclomaticComplexitySimple() {
        initM();
        assertEquals(1, new MethodMetricsCalculator(codeTestList.get(1).getCodeMethod()).getCyclomaticComplexity(), 0);
    }

    @Test
    public void testGetCyclomaticComplexity() {
        initM();
        assertEquals(3, new MethodMetricsCalculator(codeTestList.get(2).getCodeMethod()).getCyclomaticComplexity(), 0);
    }
}
