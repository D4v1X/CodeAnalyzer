package TestFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestJavaCode {

    private final File javaText;

    public TestJavaCode(String javaText) {
        this.javaText = new File(javaText);
    }

    public File getJavaText() {
        return javaText;
    }

    public Integer getNumberLines() {
        Integer NumberLines = 0;
        try {
            BufferedReader file = new BufferedReader(new FileReader(javaText));
            while (file.ready()) {
                file.readLine();
                NumberLines++;
            }
        } catch (IOException ex) {
            Logger.getLogger(TestJavaCode.class.getName()).log(Level.SEVERE, null, ex);
        }
        return NumberLines;
    }
}