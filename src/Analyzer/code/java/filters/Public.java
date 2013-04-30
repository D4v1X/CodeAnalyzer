package Analyzer.code.java.filters;

public class Public extends Filter {

    @Override
    public Boolean apply(String line) {
        return line.contains("public");
    }
}
