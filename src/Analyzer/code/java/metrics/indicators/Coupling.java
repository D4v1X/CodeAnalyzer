package Analyzer.code.java.metrics.indicators;

public class Coupling {

    private Double afferentCoupling;
    private Double efferentCoupling;

    public Coupling() {
        this.afferentCoupling = 0.0;
        this.efferentCoupling = 0.0;
    }

    public Double getAfferentCoupling() {
        return afferentCoupling;
    }

    public void setAfferentCoupling(Double afferentCoupling) {
        this.afferentCoupling = afferentCoupling;
    }

    public Double getEfferentCoupling() {
        return efferentCoupling;
    }

    public void setEfferentCoupling(Double efferentCoupling) {
        this.efferentCoupling = efferentCoupling;
    }
}
