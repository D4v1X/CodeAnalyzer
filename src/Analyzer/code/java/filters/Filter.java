package Analyzer.code.java.filters;

public abstract class Filter {

    public static final ImportFilter IMPORT = new ImportFilter();
    public static final PackageFilter PACKAGE = new PackageFilter();
    public static final MethodFilter METHOD = new MethodFilter();
    public static final EmptyFilter EMPTY = new EmptyFilter();
    public static final PrivateFilter PRIVATE = new PrivateFilter();
    public static final ClassFilter CLASS = new ClassFilter();
    public static final PublicFilter PUBLIC = new PublicFilter();
    public static final LineFilter LINE = new LineFilter();
    public static final AbstractFilter ABSTRACT = new AbstractFilter();

    public abstract Boolean apply(String line);
}
