package com.netcracker.thread;

import java.io.File;

import com.netcracker.fileWorker.XmlReaderWriter;
import com.netcracker.fileWorker.XmlReaderWriterImpl;

public class NewThread implements Runnable {
    private final Thread thread;
    private final File file;

    public NewThread(File file) {
        this.file = file;
        thread = new Thread(this, file.getPath());
        thread.start();
    }

    @Override
    public void run() {
        XmlReaderWriter xmlReaderWriter = new XmlReaderWriterImpl(file);
        xmlReaderWriter.toObject();
    }
}
