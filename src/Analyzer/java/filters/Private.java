package Analyzer.java.filters;

public class Private extends Filter{

    @Override
    public Boolean apply(String line) {
        return line.contains("private");
    }
    
}
