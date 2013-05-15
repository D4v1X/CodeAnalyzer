package Analyzer.code.java.metrics;

import Analyzer.code.FileLoader;
import Analyzer.code.java.parse.CodeParse;
import java.io.File;
import static org.junit.Assert.*;
import org.junit.Test;

public class HeadCodeMetricsTest {

    private HeadCodeMetrics codeTest;

    public HeadCodeMetricsTest() {
        FileLoader fileLoader = new FileLoader("." + File.separator + "test" + File.separator + "TestFiles" + File.separator + "CodeFile0.java");
        CodeParse codeParse = new CodeParse(fileLoader.toArray());
        codeParse.splitCode();
        Metrics[] metricsCalculators = codeParse.getMetricsList();
        codeTest = (HeadCodeMetrics) metricsCalculators[0];
    }
//Todo hacer Test

    @Test
    public void testGetLibraryDependency() {
        assertEquals(2, codeTest.getLibraryDependency(), 0);
    }
}
