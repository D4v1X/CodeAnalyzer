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
        for (File fileIterator : file.listFiles()) {
            childrenSelector(fileIterator, directory);
        }
        return directory;
    }

    private static void childrenSelector(File fileIterator, Directory directory) throws IOException {
        if (fileIterator.isDirectory()) {
            directory.addGenericFileChild(FileAnalyzer.createDirectoryTree(fileIterator.getPath()));
        }
        if (fileIterator.getName().endsWith(".java")) {
            directory.addGenericFileChild(new CodeFile(fileIterator.getPath()));
        }
    }
}
