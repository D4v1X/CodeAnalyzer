package Analyzer.code.java.component;

import Analyzer.code.java.metrics.Coupling;
import java.util.ArrayList;
import java.util.List;

public class MyClass extends Component {

    private Integer numberAttributes;
    private Coupling coupling;
    private List<MyMethod> myMethodList;

    public MyClass(String name) {
        super(name);
        this.numberAttributes = 0;
        this.myMethodList = new ArrayList<>();
        this.coupling = new Coupling();
    }

    public Integer getNumberAttributes() {
        return numberAttributes;
    }

    public void increaseNumberAttributes() {
        this.numberAttributes++;
    }

    public MyMethod[] getMyMethodList() {
        return myMethodList.toArray(new MyMethod[myMethodList.size()]);
    }

    public void addMyMethod(MyMethod myMethod) {
        this.myMethodList.add(myMethod);
    }

    public Integer getAfferentCoupling() {
        return coupling.getAfferentCoupling();
    }

    public void setAfferentCoupling(Integer afferentCoupling) {
        coupling.setAfferentCoupling(afferentCoupling);
    }

    public Integer getEfferentCoupling() {
        return coupling.getEfferentCoupling();
    }

    public void setEfferentCoupling(Integer efferentCoupling) {
        coupling.setEfferentCoupling(efferentCoupling);
    }
}
