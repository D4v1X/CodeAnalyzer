package Analyzer.code.java.filters;

public class ClassFilter extends Filter {

    @Override
    public Boolean apply(String line) {
        return line.contains("class");
    }
}
