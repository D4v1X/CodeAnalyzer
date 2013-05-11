package Analyzer.code;

import Analyzer.code.java.Analyzer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileLoader {

    private BufferedReader bufferCodeLine;
    private File codeFile;
    private FileReader fileReader;
    private final String path;

    public FileLoader(String path) {
        this.path = path;
    }

    public String[] toArray() {
        String line;
        ArrayList<String> code = new ArrayList<>();
        if (open()) {
            line = getLine();
            while (line != null) {
                code.add(line);
                line = getLine();
            }
            close();
        }
        return code.toArray(new String[code.size()]);
    }

    private Boolean open() {
        try {
            codeFile = new File(path);
            fileReader = new FileReader(codeFile);
            bufferCodeLine = new BufferedReader(fileReader);
        } catch (IOException ex) {
            Logger.getLogger(Analyzer.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    private String getLine() {
        String line = null;
        try {
            line = bufferCodeLine.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Analyzer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return line;
    }

    private Boolean close() {
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
