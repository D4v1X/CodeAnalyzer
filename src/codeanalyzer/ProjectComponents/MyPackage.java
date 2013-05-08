package codeanalyzer.ProjectComponents;

import java.util.ArrayList;
import java.util.List;

public class MyPackage {
    
    private List<MyClass> myClassList;
    
    public MyPackage() {
        myClassList = new ArrayList<>();
    }

    public MyClass[] getClassList() {
        return myClassList.toArray(new MyClass[myClassList.size()]);
    }
    
    public void addMyClass(MyClass myClass) {
        myClassList.add(myClass);
    }
    
    public Integer getClassNumber() {
        return myClassList.size();
    }
    
    public Integer getTotalCodeLines() {
        Integer totalCodeLines = 0;
        for (MyClass myClass : getClassList()) {
            totalCodeLines += myClass.getTotalCodeLines();
        }
        return totalCodeLines;
    }
    
}
