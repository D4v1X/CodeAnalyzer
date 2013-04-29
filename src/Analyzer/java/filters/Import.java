package Analyzer.java.filters;

public class Import extends Filter {

    @Override
    public Boolean apply(String line) {
        return line.contains("import");
    }
}
