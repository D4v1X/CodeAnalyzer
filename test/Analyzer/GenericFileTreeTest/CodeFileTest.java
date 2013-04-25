package Analyzer.GenericFileTreeTest;

import Analyzer.GenericFileTree.CodeFile;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CodeFileTest {

    CodeFile codeFile;

    @Before
    public void createCodeFile() {
        codeFile = new CodeFile(".\\test\\TestFiles\\CodeFile1.java");
    }

    @Test
    public void testIsDirectory() {
        assertFalse(codeFile.isDirectory());
    }

    @Test
    public void testIsCodeFile() {
        assertTrue(codeFile.isCodeFile());
    }
}