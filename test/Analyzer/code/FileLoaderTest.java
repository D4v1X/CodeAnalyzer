package Analyzer.code;

import java.io.File;
import static org.junit.Assert.*;
import org.junit.Test;

public class FileLoaderTest {

    @Test
    public void testAlert() {
        // TODO Hacer los Tests que faltan
        fail("Hacer los Tests que faltan");
    }

    @Test
    public void testToArray() {
        FileLoader fileUtils = new FileLoader("." + File.separator + "test" + File.separator + "TestFiles" + File.separator + "CodeFile1.java");
        String[] expResult = {"package TestFiles;", "", "public class CodeFile1 {", "}"};
        String[] result = fileUtils.toArray();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testToArrayError() {
    }
}
