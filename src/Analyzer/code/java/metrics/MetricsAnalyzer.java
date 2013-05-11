package Analyzer.code.java.metrics;

import Analyzer.code.FileLoader;
import Analyzer.code.java.parse.CodeParse;
import Analyzer.structure.Directory;
import Analyzer.structure.GenericFile;

public class MetricsAnalyzer {

    public static Metrics createDirectoryTree(Directory root) {
        PackageMetrics rootpackageMetrics = new PackageMetrics(root.getSimpleName());
        for (GenericFile fileActual : root.getGenericFileChildren()) {
            childrenCreator(fileActual, rootpackageMetrics);
        }
        return rootpackageMetrics;
    }

    private static void childrenCreator(GenericFile fileActual, PackageMetrics rootpackageMetrics) {
        if (fileActual.isDirectory()) {
            rootpackageMetrics.addMetrics(MetricsAnalyzer.createDirectoryTree((Directory) fileActual));
        }
        if (fileActual.isCodeFile()) {
            FileLoader fileUtils = new FileLoader(fileActual.getPath());
            CodeParse code = new CodeParse(fileUtils.toArray());
            code.splitCode();
            Metrics[] metrics = code.getMetricsList();
            for (Metrics m : metrics) {
                rootpackageMetrics.addMetrics(m);
            }
        }
    }
}
