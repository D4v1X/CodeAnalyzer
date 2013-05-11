package Analyzer.code.java.metrics;

public class HeadCodeMetrics extends Metrics {

    private String[] headCode;

    public HeadCodeMetrics(String name, String[] headCode) {
        super(name);
        this.headCode = headCode;
    }
}
