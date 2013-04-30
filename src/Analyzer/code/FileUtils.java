package Analyzer.code;

import Analyzer.code.java.Analyzer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileUtils {

    private BufferedReader bufferCodeLine;
    private File codeFile;
    private FileReader fileReader;
    private final String code;

    public FileUtils(String code) {
        this.code = code;
    }

    public Boolean open() {
        try {
            codeFile = new File(code);
            fileReader = new FileReader(codeFile);
            bufferCodeLine = new BufferedReader(fileReader);
        } catch (IOException ex) {
            Logger.getLogger(Analyzer.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public String getLine() {
        String line = null;
        try {
            line = bufferCodeLine.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Analyzer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return line;
    }

    public Boolean close() {
        try {
            fileReader.close();
            bufferCodeLine.close();
        } catch (IOException ex) {
            Logger.getLogger(Analyzer.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
