package codeanalyzer.ProjectComponents;

import codeanalyzer.ProjectComponents.MetricClass.CodeLines;
import codeanalyzer.ProjectComponents.MetricClass.Coupling;
import java.util.ArrayList;
import java.util.List;

public class MyClass {
    private String name;
    private Integer numberAttributes;
    private CodeLines codeLines;
    private Coupling coupling;
    private List<MyMethod> myMethodList;

    public MyClass(String name) {
        this.name = name;
        this.numberAttributes = 0;
        this.codeLines = new CodeLines();
        this.myMethodList = new ArrayList<>();
        this.coupling = new Coupling();
    }

    public String getName() {
        return name;
    }

    public Integer getNumberAttributes() {
        return numberAttributes;
    }

    public void increaseNumberAttributes() {
        this.numberAttributes++;
    }

    public Integer getEffectiveCodeLines() {
        return codeLines.getEffectiveLines();
    }
    
    public Integer getBlankCodeLines() {
        return codeLines.getBlankLines();
    }
    
    public Integer getCommentCodeLines() {
        return codeLines.getCommentLines();
    }

    public void setCodeLines(Integer effectiveLines, Integer blankLines, Integer commentLines) {
        codeLines.setBlankLines(blankLines);
        codeLines.setCommentLines(commentLines);
        codeLines.setEffectiveLines(effectiveLines);
    }
    
    public Integer getTotalCodeLines() {
        return codeLines.getBlankLines() + codeLines.getCommentLines() + codeLines.getEffectiveLines();
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
