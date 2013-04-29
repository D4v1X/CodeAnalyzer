package Analyzer.java.filters;

public class Public extends Filter{

    @Override
    public Boolean apply(String line) {
        return line.contains("public");
    }
    
}
