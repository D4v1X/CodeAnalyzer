package Analyzer.structure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileAnalyzer {

    public static GenericFile createDirectoryTree(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        Directory directory = new Directory(file.getPath());
        for (File fileActual : file.listFiles()) {
            childrenSelector(fileActual, directory);
        }
        return directory;
    }

    private static void childrenSelector(File fileActual, Directory directory) throws IOException {
        if (fileActual.isDirectory()) {
            directory.addGenericFileChild(FileAnalyzer.createDirectoryTree(fileActual.getPath()));
        }
        if (fileActual.getName().endsWith(".java")) {
            directory.addGenericFileChild(new CodeFile(fileActual.getPath()));
        }
    }
}
