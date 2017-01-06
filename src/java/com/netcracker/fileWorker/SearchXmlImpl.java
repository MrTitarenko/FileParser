package com.netcracker.fileWorker;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchXmlImpl implements SearchXml {
    private List<File> fileList = new ArrayList<>();

    @Override
    public List<File> onlyInRootFolder(File root) {
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File path) {
                return path.toString().endsWith(".xml");
            }
        };
        fileList = Arrays.asList(root.listFiles(filter));
        return fileList;
    }

    @Override
    public List<File> inAllFolders(File root) {
        if (root.isFile()) {
            if (root.toString().endsWith(".xml")) {
                fileList.add(root);
            }
        } else {
            for (File file : root.listFiles()) {
                inAllFolders(file);
            }
        }
        return fileList;
    }
}
