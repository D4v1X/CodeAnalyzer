package Analyzer.java.filters;

public class Class extends Filter {

    @Override
    public Boolean apply(String line) {
        return line.contains("class");
    }
}
