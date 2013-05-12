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
        assertEquals(1, code.getMetricsListSize(), 0);
    }

    @Test
    public void testSplitCodeComplex() {
        codeComplex.splitCode();
        assertEquals(1, codeComplex.getMetricsListSize(), 0);
        Metrics[] m= codeComplex.getMetricsList();
        ClassMetrics cm =  (ClassMetrics) m[0];
        assertEquals(3, cm.getMethodMetricsListSize(),0);
    }

    @Test
    public void testGetFullNamePackage() {
        String line = "package TestFiles;";
        assertEquals("TestFiles", code.getFullNamePackage(line));
    }

    @Test
    public void testGetFullNamePackage2() {
        String line = "package Analyzer.code.java.parse;";
        assertEquals("Analyzer.code.java.parse", code.getFullNamePackage(line));
    }

    @Test
    public void testGetFullNameClass() {
        String line = "public class CodeFile1 {";
        String namePackage = "TestFiles";
        assertEquals("TestFiles.CodeFile1", code.getFullNameClass(line, namePackage));
    }

    @Test
    public void testGetFullNameMethod() {
        String line = "    public String getFullNameMethod(String line, String fullNameClass) {";
        String nameClass = "TestFiles.CodeFile1";
        assertEquals("TestFiles.CodeFile1.getFullNameMethod", code.getFullNameMethod(line, nameClass));
    }
}
