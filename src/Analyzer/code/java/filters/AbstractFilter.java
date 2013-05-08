package Analyzer.code.java.filters;

public class AbstractFilter extends Filter{

    @Override
    public Boolean apply(String line) {
        return line.contains("abstract");
    }
    
}
