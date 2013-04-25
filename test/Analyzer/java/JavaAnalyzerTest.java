package Analyzer.java;

import static org.junit.Assert.*;
import org.junit.Test;

public class JavaAnalyzerTest {

    JavaAnalyzer javaCodeAnalyzer;

    public JavaAnalyzerTest() {
        javaCodeAnalyzer = new JavaAnalyzer("./test/TestFiles/TestJavaCode.java");
    }

    @Test
    public void testGetNumberLines() {
        assertEquals(35, javaCodeAnalyzer.getNumberLines(), 0);
    }

    @Test
    public void testGetNumberBlankLines() {
        assertEquals(6, javaCodeAnalyzer.getNumberBlankLines(), 0);
    }

    @Test
    public void testGetNumberMethods() {
        assertEquals(3, javaCodeAnalyzer.getNumberMethods(), 0);
    }

    @Test
    public void testGetNumberImports() {
        assertEquals(6, javaCodeAnalyzer.getNumberImports(), 0);
    }

    @Test
    public void testGetNumberPackages() {
        assertEquals(1, javaCodeAnalyzer.getNumberPackages(), 0);
    }

    @Test
    public void testGetNumberPublicClasses() {
        assertEquals(1, javaCodeAnalyzer.getNumberPublicClasses(), 0);
    }

    @Test
    public void testGetNumberPrivateClasses() {
        assertEquals(0, javaCodeAnalyzer.getNumberPrivateClasses(), 0);
    }
}
