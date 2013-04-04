package codeanalyzer;

import java.io.File;

public class Directory extends File {

    private File[] listFile;

    public Directory(String pathname) {
        super(pathname);
        this.listFile = this.listFiles();
    }

    public Integer getNumberDirectories() {
        Integer numberDirecties = 0;
        for (File file : listFile) {
            if (file.isDirectory()) {
                numberDirecties++;
            }
        }
        return numberDirecties;
    }

    public Integer getNumberText() {
        Integer NumberTexts = 0;
        for (File file : listFile) {
            if (!file.isDirectory()) {
                NumberTexts++;
            }
        }
        return NumberTexts;
    }

    public File[] getListFile() {
        return listFile;
    }
}
