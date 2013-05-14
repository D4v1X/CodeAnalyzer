package Analyzer.code.java;

import static org.junit.Assert.*;
import org.junit.Test;

public class ContainsTest {

    @Test
    public void testPackage() {
        assertFalse(Contains.Package("packages"));
        assertFalse(Contains.Package("Package"));
        assertTrue(Contains.Package("package"));
        assertTrue(Contains.Package("package Analyzer.code.java.parse;"));
        assertFalse(Contains.Package("packages Analyzer.code.package.parse;"));
    }

    @Test
    public void testImport() {
        assertFalse(Contains.Import("imports"));
        assertFalse(Contains.Import("Import"));
        assertTrue(Contains.Import("import"));
        assertTrue(Contains.Import("import java.util.ArrayList"));
        assertFalse(Contains.Import("packages Analyzer.code.parse;"));
    }

    @Test
    public void testInterface() {
        assertFalse(Contains.Interface("interfaces"));
        assertFalse(Contains.Interface("Interface"));
        assertTrue(Contains.Interface("interface"));
    }

    @Test
    public void testMethod() {
        assertTrue(Contains.Method("public String getFullNameClass(String line, String fullNamePackage) {", "Analyzer.code.java.parse.CodeParse"));
        assertFalse(Contains.Method("public CodeParse(String[] code) { ", "Analyzer.code.java.parse.CodeParse"));
    }

    @Test
    public void testClass() {
        assertFalse(Contains.Class("Class"));
        assertFalse(Contains.Class("classes"));
        assertTrue(Contains.Class("public class CodeParse {"));
        assertTrue(Contains.Class("class CodeParse {"));
    }

    @Test
    public void testSemiColon() {
        assertTrue(Contains.SemiColon(";"));
        assertFalse(Contains.SemiColon("List<Metrics> metricsList"));
        assertTrue(Contains.SemiColon("List<Metrics> metricsList;"));
    }

    @Test
    public void testAtribute() {
        assertTrue(Contains.Atribute("public String line", "line"));
        assertFalse(Contains.Atribute("public String fullNamePackage", "line"));
        assertFalse(Contains.Atribute("private String nextLine", "line"));
        assertTrue(Contains.Atribute("public String line;", "line"));
        assertTrue(Contains.Atribute("new BufferedReader(new FileReader(javaText5));", "javaText5"));
    }
}
