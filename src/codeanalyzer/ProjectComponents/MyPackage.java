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
    
}
