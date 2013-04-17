package codeanalyzer.GenericFileTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Directory extends GenericFile {
    private List<GenericFile> genericFileChildren;

    public Directory(String path) {
        super(path);
        this.genericFileChildren = new ArrayList<>();
    }
    
        @Override
    public Boolean isDirectory() {
        return true;
    }

    @Override
    public Boolean isCodeFile() {
        return false;
    }

    public GenericFile[] getGenericFileChildren() {
        return genericFileChildren.toArray(new GenericFile[getChildrenQuantity()]);
    }
    
    public GenericFile getGenericFileChild(Integer index){
        return genericFileChildren.get(index);
    }
    
    public void addGenericFileChild(GenericFile genericFile){
        genericFileChildren.add(genericFile);
    }
    
    public Integer getChildrenQuantity(){
        return genericFileChildren.size();
    }
    
    public Integer getDirectoryChildrenQuantity(){
        Integer directoriesQuantity = new Integer(0);
        for (Iterator<GenericFile> iterator = genericFileChildren.iterator(); iterator.hasNext();) {
            GenericFile genericFile = iterator.next();
            if (genericFile.isDirectory()) directoriesQuantity++;
        }
        return directoriesQuantity;
    }

    public Integer getCodeFileChildrenQuantity(){
        Integer codeFileQuantity = new Integer(0);
        for (Iterator<GenericFile> iterator = genericFileChildren.iterator(); iterator.hasNext();) {
            GenericFile genericFile = iterator.next();
            if (genericFile.isCodeFile()) codeFileQuantity++;
        }
        return codeFileQuantity;
    }
    
}
