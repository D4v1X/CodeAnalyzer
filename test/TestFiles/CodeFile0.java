/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author davidsantiagobarrera
 */
public abstract class CodeFile0 {

    private final File javaText;

    public CodeFile0(String javaText) {
        this.javaText = new File(javaText);
    }

    public File getJavaText() {
        return javaText;
    }

    public File getJavaTextMolon(String s) {
        return javaText;
    }

    public Integer getNumberLines(Integer Prueba, String prueba2) {
        Integer NumberLines = 0;
        try {
            BufferedReader file = new BufferedReader(new FileReader(javaText));
            while (file.ready()) {
                file.readLine();
                NumberLines++;
            }
        } catch (IOException ex) {
            Logger.getLogger(CodeFile0.class.getName()).log(Level.SEVERE, null, ex);
        }
        return NumberLines;
    }
}