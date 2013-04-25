package Analyzer.GenericFileTreeTest;

import codeanalyzer.FileAnalyzer;
import Analyzer.GenericFileTree.GenericFile;
import java.io.File;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

public class FileAnalyzerTest {

    GenericFile genericFile;

    @Test
    public void testCreateDirectoryTree() {
        try {
            genericFile = FileAnalyzer.createDirectoryTree("."+File.separator+"test"+File.separator+"TestFiles");
        } catch (IOException ex) {
            assertFalse(true);
        }
    }
    String ristra = ("hola");
}