package Analyzer.code.java.metrics.calculator;

import Analyzer.code.FileLoader;
import Analyzer.code.java.parse.CodeParse;
import java.io.File;
import static org.junit.Assert.*;
import org.junit.Test;

public class ClassMetricsCalculatorTest {

    private ClassMetricsCalculator codeTest;

    public ClassMetricsCalculatorTest() {
        FileLoader fileLoader = new FileLoader("." + File.separator + "test" + File.separator + "TestFiles" + File.separator + "CodeFile0.java");
        CodeParse codeParse = new CodeParse(fileLoader.toArray());
        codeParse.splitCodev2();
        MetricsCalculator[] metricsCalculators = codeParse.getMetricsCalculatorsList();
        codeTest = (ClassMetricsCalculator) metricsCalculators[1];
    }

// TODO Hacer Test que faltan
    @Test
    public void testAddMethod() {
    }

    @Test
    public void testGetNumberOfMethod() {
    }

    @Test
    public void testGetNumberOfAttribute() {
        assertEquals(10, codeTest.getNumberOfAttribute(), 0);
    }

    @Test
    public void testGetLackOfCohesion() {
        assertEquals(0.8, codeTest.getLackOfCohesion(), 0.001);
    }
}
