package Analyzer.java.filters;

public class Empty extends Filter {

    @Override
    public Boolean apply(String line) {
        return line.isEmpty();
    }
}
