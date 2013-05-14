package Analyzer.code.java;

public class Contains {

    public static Boolean Package(String line) {
        return line.contains("package");
    }

    public static Boolean Import(String line) {
        return line.contains("import");
    }

    public static Boolean Interface(String line) {
        return line.contains("interface");
    }

    public static Boolean Method(String line, String simpleNameClass) {
        return Function(line) && (!line.contains(simpleNameClass));
    }

    public static Boolean Constructor(String line, String simpleNameClass) {
        return Function(line) && (line.contains(simpleNameClass));
    }

    public static Boolean Function(String line) {
        return (line.contains("private") || line.contains("public") || line.contains("protected")) && (line.contains("("));
    }

    public static Boolean Class(String line) {
        return line.contains("class");
    }

    public static Boolean SemiColon(String line) {
        return line.contains(";");
    }

    public static Boolean Atribute(String line, String attribute) {
        return line.contains(attribute);
    }
    //TODO
    //Split and Verify tokens para corregir subristras
}
