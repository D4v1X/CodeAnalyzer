package Analyzer.GenericFileTreeTest;

import codeanalyzer.FileAnalyzer;
import Analyzer.GenericFileTree.Directory;
import Analyzer.GenericFileTree.GenericFile;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DirectoryTest {

    Directory directory;

    @Before
    public void createDirectory() {
        try {
            directory = (Directory) FileAnalyzer.createDirectoryTree(".\\test\\TestFiles");
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
        assertEquals(3, directory.getChildrenQuantity(), 0);
    }

    @Test
    public void testGetDirectoryChildrenQuantity() {
        assertEquals(1, directory.getDirectoryChildrenQuantity(), 0);
    }

    @Test
    public void testGetCodeFileChildrenQuantity() {
        assertEquals(2, directory.getCodeFileChildrenQuantity(), 0);
    }

    @Test
    public void testGetGenericFileChildren() {
        GenericFile[] fileList = directory.getGenericFileChildren();
        String[] pathList = new String[3];
        pathList[0] = ".\\test\\TestFiles\\CodeFile1.java";
        pathList[1] = ".\\test\\TestFiles\\CodeFile2.java";
        pathList[2] = ".\\test\\TestFiles\\Directory1";
        int i = 0;
        for (GenericFile child : fileList) {
            assertEquals(child.getPath(), pathList[i]);
            i++;
        }
    }
}