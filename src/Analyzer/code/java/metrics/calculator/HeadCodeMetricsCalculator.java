package Analyzer.code.java.metrics.calculator;

import Analyzer.code.java.Contains;
import java.util.ArrayList;
import java.util.List;

public class HeadCodeMetricsCalculator extends CodeMetricsCalculator {

    private List<String> importList;
    private List<String> libraryList;
    private String namePackage;
    private String rootNamePackage;

    public HeadCodeMetricsCalculator(String[] code) {
        super(code);
        this.importList = new ArrayList<>();
        this.libraryList = new ArrayList<>();
        extractNamePackage();
        extractRootNamePackage();
    }

    private Boolean extractNamePackage() {
        for (String line : code) {
            if (Contains.Package(line)) {
                String[] tokens = line.split("[ ;]");
                namePackage = tokens[1];
                return true;
            }
        }
        return false;
    }

    private void extractRootNamePackage() {
        String[] tokens = namePackage.split(".");
        if (tokens.length == 0) {
            rootNamePackage = namePackage;
        } else {
            rootNamePackage = tokens[0];
        }
    }

    public Integer getLibraryDependency() {
        String[] tokens;
        for (String line : code) {
            if (Contains.Import(line)) {
                tokens = line.split("[ ;]");
                importList.add(tokens[tokens.length - 1]);
            }
        }
        for (String nameImport : importList) {
            tokens = nameImport.split("[.]");
            String namelibrary = tokens[0];
            if (!namelibrary.equals(rootNamePackage) && !libraryList.contains(namelibrary)) {
                libraryList.add(namelibrary);
            }
        }
        return libraryList.size();
    }
}
