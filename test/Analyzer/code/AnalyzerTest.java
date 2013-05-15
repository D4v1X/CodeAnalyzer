package Analyzer.code;

import Analyzer.code.Analyzer;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AnalyzerTest {

    Analyzer javaAnalyzer;

    @Before
    public void JavaAnalyzer() {
        javaAnalyzer = new Analyzer("./test/TestFiles");
    }

    @Test
    public void testStart() {
        //TODO Hacer Test Start
    }
}
