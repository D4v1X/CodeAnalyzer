package Analyzer.code.java.metrics.calculator;

import Analyzer.code.FileLoader;
import Analyzer.code.java.parse.CodeParse;
import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;

public class HeadCodeMetricsCalculatorTest {

    private HeadCodeMetricsCalculator codeTest;

    public HeadCodeMetricsCalculatorTest() {
        FileLoader fileLoader = new FileLoader("." + File.separator + "test" + File.separator + "TestFiles" + File.separator + "CodeFile0.java");
        CodeParse codeParse = new CodeParse(fileLoader.toArray());
        codeParse.splitCodev2();
        MetricsCalculator[] metricsCalculators = codeParse.getMetricsCalculatorsList();
        codeTest = (HeadCodeMetricsCalculator) metricsCalculators[0];
    }
//Todo hacer Test

    @Test
    public void testGetLibraryDependency() {
        assertEquals(2, codeTest.getLibraryDependency(), 0);
    }
}
