package Analyzer.java;

import Analyzer.FileUtils;
import Analyzer.java.filters.Filter;

public class Analyzer {

    private final FileUtils codeFile;

    public Analyzer(String javaText) {
        this.codeFile = new FileUtils(javaText);
    }

    public Integer getNumberLines() {
        Filter[] filters = {Filter.LINE};
        return Search(filters);
    }

    public Integer getNumberBlankLines() {
        Filter[] filters = {Filter.EMPTY};
        return Search(filters);
    }

    public Integer getNumberMethods() {
        Filter[] filters = {Filter.METHOD};
        return Search(filters);
    }

    public Integer getNumberImports() {
        Filter[] filters = {Filter.IMPORT};
        return Search(filters);
    }

    public Integer getNumberPackages() {
        Filter[] filters = {Filter.PACKAGE};
        return Search(filters);
    }

    public Integer getNumberPublicClasses() {
        Filter[] filters = {Filter.PUBLIC, Filter.CLASS};
        return Search(filters);
    }

    public Integer getNumberPrivateClasses() {
        Filter[] filters = {Filter.PRIVATE, Filter.CLASS};
        return Search(filters);
    }

    private Integer Search(Filter[] filters) {
        Integer numberOcurrences = 0;
        codeFile.open();
        String line = codeFile.getLine();
        while (line != null) {
            Integer trues = 0;
            for (Filter filter : filters) {
                if (filter.apply(line)) {
                    trues++;
                }
            }
            if (trues == filters.length) {
                numberOcurrences++;
            }
            line = codeFile.getLine();
        }
        codeFile.close();
        return numberOcurrences;
    }
}
