package Analyzer;

public class JavaCodeAnalyzer extends CodeAnalyzer {
    
    private final CodeFile codeFile;
    
    public JavaCodeAnalyzer(String javaText) {
        this.codeFile = new CodeFile(javaText);
    }
    
    public Integer getNumberLines() {
        Integer NumberLines = 0;
        codeFile.open();
        while (codeFile.getLine() != null) {
            NumberLines++;
        }
        codeFile.close();
        return NumberLines;
    }
    
    public Integer getNumberBlankLines() {
        Integer NumberLines = 0;
        codeFile.open();
        String line = codeFile.getLine();
        while (line != null) {
            if (line.isEmpty()) {
                NumberLines++;
            }
            line = codeFile.getLine();
        }
        codeFile.close();
        return NumberLines;
    }
    
    public Integer getNumberMethods() {
        Integer NumberMethods = 0;
        codeFile.open();
        String line = codeFile.getLine();
        while (line != null) {
            if ((line.contains("private") || line.contains("public") || line.contains("protected")) && (line.contains("("))) {
                NumberMethods++;
            }
            line = codeFile.getLine();
        }
        codeFile.close();
        return NumberMethods;
    }
    
    public Integer getNumberImports() {
        return SearchString("import");
    }
    
    public Integer getNumberPackages() {
        return SearchString("package");
    }
    
    public Integer getNumberPublicClasses() {
        return SearchString("public class");
    }
    
    public Integer getNumberPrivateClasses() {
        return SearchString("private class");
    }
    
    private Integer SearchString(String word) {
        Integer NumberImports = 0;
        codeFile.open();
        String line = codeFile.getLine();
        while (line != null) {
            if (line.contains(word)) {
                NumberImports++;
            }
            line = codeFile.getLine();
        }
        codeFile.close();
        return NumberImports;
    }
}
