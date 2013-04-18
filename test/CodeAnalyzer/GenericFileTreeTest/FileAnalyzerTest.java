
package CodeAnalyzer.GenericFileTreeTest;

import codeanalyzer.FileAnalyzer;
import codeanalyzer.GenericFileTree.GenericFile;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

public class FileAnalyzerTest {
    GenericFile genericFile;
    
    @Test
    public void testCreateDirectoryTree(){
        try {
            genericFile = FileAnalyzer.createDirectoryTree(".\\test\\TestFiles");
        } catch (IOException ex) {
            assertFalse(true);
        }
    }
    String ristra = ("hola");
}