package Analyzer.code.java.metrics;

import Analyzer.code.FileLoader;
import Analyzer.code.java.parse.CodeParse;
import java.io.File;
import static org.junit.Assert.*;
import org.junit.Test;

public class HeadMetricsTest {

    private HeadMetrics codeTest;

    public HeadMetricsTest() {
        FileLoader fileLoader = new FileLoader("." + File.separator + "test" + File.separator + "TestFiles" + File.separator + "CodeFile0.java");
        CodeParse codeParse = new CodeParse(fileLoader.toArray());
        codeParse.splitCode();
        Metrics[] metricsCalculators = codeParse.getMetricsList();
        codeTest = (HeadMetrics) metricsCalculators[0];
    }

    @Test
    public void testGetLibraryDependency() {
        assertEquals(2, codeTest.getLibraryDependency(), 0);
    }

    @Test
    public void testGetNamePackage() {
        assertEquals("TestFiles", codeTest.getNamePackage());
    }
}
