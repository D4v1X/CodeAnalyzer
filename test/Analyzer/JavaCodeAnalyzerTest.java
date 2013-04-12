/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Analyzer;

import java.io.File;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author davidsantiagobarrera
 */
public class JavaCodeAnalyzerTest {

    JavaCodeAnalyzer javaCodeAnalyzer;

    public JavaCodeAnalyzerTest() {
        javaCodeAnalyzer = new JavaCodeAnalyzer("./test/TestFiles/TestJavaCode.java");
    }

    @Test
    public void testGetJavaText() {
        File testFile = new File("./test/TestFiles/TestJavaCode.java");
        assertEquals(testFile, javaCodeAnalyzer.getJavaText());
    }

    @Test
    public void testGetNumberLines() {
        assertEquals(43, javaCodeAnalyzer.getNumberLines(), 0);
    }
}
