package Analyzer.code.java.metrics;

import Analyzer.code.FileLoader;
import Analyzer.code.java.parse.CodeParse;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class MethodMetricsTest {

    MethodMetrics codeTest;
    List<MethodMetrics> codeTestList;

    public MethodMetricsTest() {
        FileLoader fileLoader = new FileLoader("." + File.separator + "test" + File.separator + "TestFiles" + File.separator + "CodeFile0.java");
        CodeParse codeParse = new CodeParse(fileLoader.toArray());
        codeParse.splitCode();
        Metrics[] metrics = codeParse.getMetricsList();
        for (Metrics m : metrics) {
            if (m instanceof ClassMetrics) {
                codeTestList = new ArrayList<>(Arrays.asList(((ClassMetrics) m).getMethodMetricsList()));
            }
        }
        codeTest = new MethodMetrics(fileLoader.toArray());
    }

    @Test
    public void testGetCodeLinesComment() {
        assertEquals(8, codeTest.getCodeLines().getCommentLines(), 0);
    }

    @Test
    public void testGetCodeLinesBlank() {
        assertEquals(9, codeTest.getCodeLines().getBlankLines(), 0);
    }

    @Test
    public void testGetCodeLineseffective() {
        assertEquals(56, codeTest.getCodeLines().getEffectiveLines(), 0);
    }

    @Test
    public void testGetNumberOfParametersEmpty() {
        assertEquals(0, codeTestList.get(0).getNumberOfParameters(), 0);
    }

    @Test
    public void testGetNumberOfParametersNonEmpty() {
        assertEquals(1, codeTestList.get(1).getNumberOfParameters(), 0);
    }

    @Test
    public void testGetNumberOfParametersNonEmptyTwo() {
        assertEquals(2, codeTestList.get(2).getNumberOfParameters(), 0);
    }

    @Test
    public void testGetCyclomaticComplexitySimple() {
        assertEquals(1, codeTestList.get(1).getCyclomaticComplexity(), 0);
    }

    @Test
    public void testGetCyclomaticComplexity() {
        assertEquals(3, codeTestList.get(2).getCyclomaticComplexity(), 0);
    }
}
