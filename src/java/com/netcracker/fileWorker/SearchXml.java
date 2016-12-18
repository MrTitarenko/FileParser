package com.netcracker.fileWorker;

import java.io.File;
import java.util.List;

public interface SearchXml {

    List<File> onlyInRootFolder(File root);

    List<File> inAllFolders(File root);
}
