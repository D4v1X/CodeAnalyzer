package Analyzer.code.java.metrics;

public class Coupling {

    private Integer afferentCoupling;
    private Integer efferentCoupling;

    public Coupling() {
        this.afferentCoupling = 0;
        this.efferentCoupling = 0;
    }

    public Integer getAfferentCoupling() {
        return afferentCoupling;
    }

    public void setAfferentCoupling(Integer afferentCoupling) {
        this.afferentCoupling = afferentCoupling;
    }

    public Integer getEfferentCoupling() {
        return efferentCoupling;
    }

    public void setEfferentCoupling(Integer efferentCoupling) {
        this.efferentCoupling = efferentCoupling;
    }
}
