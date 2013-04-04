/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codeanalyzer;

import java.io.File;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author davidsantiagobarrera
 */
public class DirectoryTest {

    private Directory carpeta;

    public DirectoryTest() {
        carpeta = new Directory("./src");
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
        assertEquals("src", carpeta.getName());
    }

    @Test
    public void testgetPath() {
        assertEquals("./src", carpeta.getPath());
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
        Directory prueba = new Directory("./src/codeanalyzer");
        listFile.add(prueba);
        assertEquals(listFile.get(0), carpeta.getListFile()[1]);
    }
}
