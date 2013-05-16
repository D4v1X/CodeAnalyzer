/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestFiles;

import TestFiles.Directory1.CodeFile4;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author davidsantiagobarrera
 */
public abstract class CodeFile0 {

    private File javaText0;
    private File javaText1;
    private File javaText2;
    private File javaText3;
    private File javaText4;
    private File javaText5;
    private File javaText6;
    private File javaText7;
    private File javaText8;
    private File javaText9;

    public CodeFile0(String javaText) {
        this.javaText0 = new File(javaText);
    }

    public File getJavaText() {
        javaText1 = null;
        return javaText0;
    }

    public File getJavaTextMolon(String s) {
        javaText2 = null;
        return javaText3;
    }

    public Integer getNumberLines(Integer Prueba, String prueba2) {

        /*
         *  comment
         */

        Integer NumberLines = 0;
        CodeFile4 codeFile3 = new CodeFile4();
        try {
            BufferedReader file = new BufferedReader(new FileReader(javaText5));
            while (file.ready()) {
                file.readLine();
                NumberLines++;
            }
        } catch (IOException ex) {
            Logger.getLogger(CodeFile0.class.getName()).log(Level.SEVERE, null, ex);
        }
        javaText4 = null;
        return NumberLines;
    }

    public File getJavaTextMolon2(String s) {
        javaText6 = null;
        return javaText7;
    }

    public File getJavaTextMolon3(String s) {
        javaText8 = null;
        return javaText9;
    }
}