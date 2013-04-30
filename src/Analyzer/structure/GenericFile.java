package Analyzer.structure;

public abstract class GenericFile {

    private String path;

    public GenericFile(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public abstract Boolean isDirectory();

    public abstract Boolean isCodeFile();
}
