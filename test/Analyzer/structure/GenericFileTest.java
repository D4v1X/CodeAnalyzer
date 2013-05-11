package Analyzer.structure;

import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;

public class GenericFileTest {

    private GenericFile genericFileDir;
    private GenericFile genericFileCode;

    public GenericFileTest() {
        genericFileDir = new Directory("." + File.separator + "test" + File.separator + "TestFiles");
        genericFileCode = new CodeFile("." + File.separator + "test" + File.separator + "TestFiles" + File.separator + "CodeFile1.java");
    }

    @Test
    public void testGetPath() {
    }

    @Test
    public void testGetSimpleNameDir() {
        assertEquals("TestFiles", genericFileDir.getSimpleName());
    }

    @Test
    public void testGetSimpleNameCode() {
        assertEquals("CodeFile1.java", genericFileCode.getSimpleName());
    }

    @Test
    public void testIsDirectory() {
    }

    @Test
    public void testIsCodeFile() {
    }
}
