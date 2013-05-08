package Analyzer.code.java.filters;

public class PrivateFilter extends Filter {

    @Override
    public Boolean apply(String line) {
        return line.contains("private");
    }
}
