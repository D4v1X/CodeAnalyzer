package Analyzer.code.java.filters;

public abstract class Filter {

    public static final Import IMPORT = new Import();
    public static final Package PACKAGE = new Package();
    public static final Method METHOD = new Method();
    public static final Empty EMPTY = new Empty();
    public static final Private PRIVATE = new Private();
    public static final Class CLASS = new Class();
    public static final Public PUBLIC = new Public();
    public static final Line LINE = new Line();
    public static final Abstract ABSTRACT = new Abstract();

    public abstract Boolean apply(String line);
}
