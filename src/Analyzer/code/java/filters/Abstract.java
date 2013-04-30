package Analyzer.code.java.filters;

public class Abstract extends Filter{

    @Override
    public Boolean apply(String line) {
        return line.contains("abstract");
    }
    
}
