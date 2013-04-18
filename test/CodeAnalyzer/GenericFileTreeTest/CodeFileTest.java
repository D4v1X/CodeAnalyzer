
package CodeAnalyzer.GenericFileTreeTest;

import codeanalyzer.GenericFileTree.CodeFile;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class CodeFileTest {
    
    CodeFile codeFile;
    
    @Before
    public void createCodeFile() {
        codeFile = new CodeFile(".\\test\\TestFiles\\CodeFile1.java");
    }
    
    @Test
    public void testIsDirectory(){
        assertFalse(codeFile.isDirectory());
    }
    
    @Test
    public void testIsCodeFile(){
        assertTrue(codeFile.isCodeFile());
    }

}