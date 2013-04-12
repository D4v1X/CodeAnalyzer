/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Analyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author davidsantiagobarrera
 */
public class JavaCodeAnalyzer extends CodeAnalyzer{
    private final File javaText; 

    public JavaCodeAnalyzer(String javaText) {
        this.javaText = new File(javaText);
    }

    public File getJavaText() {
        return javaText;
    }
    
    public Integer getNumberLines(){
        Integer NumberLines = 0;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(javaText);
            BufferedReader file = new BufferedReader(fileReader);
            while(file.ready()){
                file.readLine();
                NumberLines++;
            }
        } catch (IOException ex) {
            Logger.getLogger(JavaCodeAnalyzer.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException ex) {
                    Logger.getLogger(JavaCodeAnalyzer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return NumberLines;
    }
}
