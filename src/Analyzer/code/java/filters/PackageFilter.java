package Analyzer.code.java.filters;

public class PackageFilter extends Filter {

    @Override
    public Boolean apply(String line) {
        return line.contains("package");
    }
}
