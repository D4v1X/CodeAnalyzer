package Analyzer.structure;

import java.io.File;

public abstract class GenericFile {

    private String path;

    public GenericFile(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public String getSimpleName() {
        String[] tokens = path.split(File.separator);
        return tokens[tokens.length - 1];
    }

    public abstract Boolean isDirectory();

    public abstract Boolean isCodeFile();
}
