package codeanalyzer.ProjectComponents;

public class MyMethod extends Component{
    
    private Integer cyclomaticComplexity;
    private Integer parametersNumber;
    
    public MyMethod(String name) {
        super(name);
    }

    public void setCyclomaticComplexity(Integer cyclomaticComplexity) {
        this.cyclomaticComplexity = cyclomaticComplexity;
    }

    public Integer getCyclomaticComplexity() {
        return cyclomaticComplexity;
    }
    
    public void setParemetersNumber(Integer parametersNumber) {
        this.parametersNumber = parametersNumber;
    }
    
    public Integer getParametersNumber() {
        return parametersNumber;
    }
    
}
