package Analyzer.code.java.parse;

import Analyzer.code.FileLoader;
import Analyzer.code.java.metrics.ClassMetrics;
import Analyzer.code.java.metrics.Metrics;
import java.io.File;
import static org.junit.Assert.*;
import org.junit.Test;

public class CodeParseTest {

    CodeParse code;
    CodeParse codeComplex;

    public CodeParseTest() {
        FileLoader fileUtilsS = new FileLoader("." + File.separator + "test" + File.separator + "TestFiles" + File.separator + "CodeFile1.java");
        FileLoader fileUtilsC = new FileLoader("." + File.separator + "test" + File.separator + "TestFiles" + File.separator + "CodeFile0.java");
        code = new CodeParse(fileUtilsS.toArray());
        codeComplex = new CodeParse(fileUtilsC.toArray());
    }

    @Test
    public void testSplitCode() {
        code.splitCode();
        assertEquals(2.0, code.getMetricsListSize(), 0.0);
    }

    @Test
    public void testSplitCodeComplex() {
        codeComplex.splitCode();
        assertEquals(2.0, codeComplex.getMetricsListSize(), 0.0);
        Metrics[] m = codeComplex.getMetricsList();
        ClassMetrics cm = (ClassMetrics) m[1];
        assertEquals(5.0, cm.getMethodMetricsListSize(), 0.0);
    }
}
