package Analyzer.structure;

public class CodeFile extends GenericFile {

    public CodeFile(String path) {
        super(path);
    }

    @Override
    public Boolean isDirectory() {
        return false;
    }

    @Override
    public Boolean isCodeFile() {
        return true;
    }
}
