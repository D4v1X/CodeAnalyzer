/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Analyzer.code.java.metrics.calculator;

import Analyzer.code.FileLoader;
import Analyzer.code.java.metrics.ClassMetrics;
import Analyzer.code.java.metrics.Metrics;
import Analyzer.code.java.parse.CodeParse;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author davidsantiagobarrera
 */
public class ClassMetricsCalculatorTest {

    private ClassMetricsCalculator codeTest;
    private String[] codeTestString;

    public ClassMetricsCalculatorTest() {
        FileLoader fileLoader = new FileLoader("." + File.separator + "test" + File.separator + "TestFiles" + File.separator + "CodeFile3.java");
        codeTest = new ClassMetricsCalculator(fileLoader.toArray());
    }
    
        public void initM() {
        FileLoader fileLoader = new FileLoader("." + File.separator + "test" + File.separator + "TestFiles" + File.separator + "CodeFile0.java");
        CodeParse codeParse = new CodeParse(fileLoader.toArray());
        codeParse.splitCode();
        Metrics[] metrics = codeParse.getMetricsList();
        for (Metrics m : metrics) {
            if (m instanceof ClassMetrics) {
                codeTestString = ((ClassMetrics) m).getCodeClass();
            }
        }

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
        initM();
        assertEquals(2, new ClassMetricsCalculator(codeTestString).getNumberOfAttribute(),0);
    }
}
