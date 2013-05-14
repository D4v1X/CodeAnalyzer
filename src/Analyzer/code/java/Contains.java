package Analyzer.code.java;

public class Contains {

    public static Boolean Package(String line) {
        return Filter(line, "[ ]", "package");
    }

    public static Boolean Import(String line) {
        return Filter(line, "[ ]", "import");
    }

    public static Boolean Interface(String line) {
        return Filter(line, "[ ]", "interface");
    }

    public static Boolean Method(String line, String FullNameClass) {
        String[] tokens = FullNameClass.split("[()]");
        String[] simpleName = tokens[0].split("[.]");
        return (Function(line) && (!Filter(line, "[() ]", simpleName[simpleName.length - 1])));
    }

    public static Boolean Function(String line) {
        return (line.contains("private") || line.contains("public") || line.contains("protected")) && (line.contains("("));
    }

    public static Boolean Class(String line) {
        return Filter(line, "[ ]", "class");
    }

    public static Boolean SemiColon(String line) {
        return line.contains(";");
    }

    public static Boolean Atribute(String line, String attribute) {
        return Filter(line, "[(); ]", attribute);
    }

    public static boolean openBrace(String line) {
        return line.contains("{");
    }

    public static boolean closeBrace(String line) {
        return line.contains("}");
    }

    private static Boolean Filter(String line, String delimiter, String key) {
        String[] tokens = line.split(delimiter);
        for (String token : tokens) {
            if (token.contentEquals(key)) {
                return true;
            }
        }
        return false;
    }
}
