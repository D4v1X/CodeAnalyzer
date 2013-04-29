package Analyzer.java.filters;

public class Method extends Filter {

    @Override
    public Boolean apply(String line) {
        return (line.contains("private") || line.contains("public") || line.contains("protected")) && (line.contains("("));
    }
}
