package Analyzer.code.java.filters;

public class ImportFilter extends Filter {

    @Override
    public Boolean apply(String line) {
        return line.contains("import");
    }
}
