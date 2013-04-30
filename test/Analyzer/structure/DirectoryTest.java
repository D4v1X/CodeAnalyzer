package Analyzer.structure;

import java.io.File;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DirectoryTest {

    Directory directory;

    @Before
    public void createDirectory() {
        try {
            directory = (Directory) FileAnalyzer.createDirectoryTree("." + File.separator + "test" + File.separator + "TestFiles");
        } catch (IOException ex) {
            assertFalse(true);
        }
    }

    @Test
    public void testIsDirectory() {
        assertTrue(directory.isDirectory());
    }

    @Test
    public void testIsCodeFile() {
        assertFalse(directory.isCodeFile());
    }

    @Test
    public void testGetChildrenQuantity() {
        assertEquals(4, directory.getChildrenQuantity(), 0);
    }

    @Test
    public void testGetDirectoryChildrenQuantity() {
        assertEquals(1, directory.getDirectoryChildrenQuantity(), 0);
    }

    @Test
    public void testGetCodeFileChildrenQuantity() {
        assertEquals(3, directory.getCodeFileChildrenQuantity(), 0);
    }

    @Test
    public void testGetGenericFileChildren() {
        GenericFile[] fileList = directory.getGenericFileChildren();
        String[] pathList = new String[4];
        pathList[0] = "." + File.separator + "test" + File.separator + "TestFiles" + File.separator + "CodeFile0.java";
        pathList[1] = "." + File.separator + "test" + File.separator + "TestFiles" + File.separator + "CodeFile1.java";
        pathList[2] = "." + File.separator + "test" + File.separator + "TestFiles" + File.separator + "CodeFile2.java";
        pathList[3] = "." + File.separator + "test" + File.separator + "TestFiles" + File.separator + "Directory1";
        int i = 0;
        for (GenericFile child : fileList) {
            assertEquals(child.getPath(), pathList[i]);
            i++;
        }
    }
}