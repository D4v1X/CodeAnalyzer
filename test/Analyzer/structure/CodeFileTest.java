package Analyzer.structure;

import java.io.File;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CodeFileTest {

    CodeFile codeFile;

    @Before
    public void createCodeFile() {
        codeFile = new CodeFile("." + File.separator + "test" + File.separator + "TestFiles" + File.separator + "CodeFile1.java");
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