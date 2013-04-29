package Analyzer.java.filters;

public class Package extends Filter{

    @Override
    public Boolean apply(String line) {
        return line.contains("package");
    }
    
}
