package codeanalyzer;

import java.io.File;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;

public class DirectoryTest {

    private Directory carpeta;

    public DirectoryTest() {
        carpeta = new Directory("./test/TestFiles");
        System.out.println("Nombre: " + carpeta.getName());
        System.out.println("Path: " + carpeta.getPath());
        File[] p = carpeta.listFiles();
        for (File f : p) {
            System.out.println("Files: " + f.getName());
            System.out.println("Files-Path: " + f.getPath());
        }
    }

    @Test
    public void testgetName() {
        assertEquals("TestFiles", carpeta.getName());
    }

    @Test
    public void testgetPath() {
        assertEquals("./test/TestFiles", carpeta.getPath());
    }

    @Test
    public void testgetNumberDirectories() {
        assertEquals(1, carpeta.getNumberDirectories(), 0);
    }

    @Test
    public void testgetNumberText() {
        assertEquals(1, carpeta.getNumberText(), 0);
    }

    @Test
    public void testgetListFile() {
        ArrayList<File> listFile = new ArrayList<>();
        Directory prueba = new Directory("./test/TestFiles/testdirectory");
        listFile.add(prueba);
        assertEquals(listFile.get(0), carpeta.getListFile()[0]);
    }
}
