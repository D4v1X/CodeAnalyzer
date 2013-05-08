package Analyzer.code.java.filters;

public class EmptyFilter extends Filter {

    @Override
    public Boolean apply(String line) {
        return line.isEmpty();
    }
}
