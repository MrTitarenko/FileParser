package com.netcracker;

import com.netcracker.fileWorker.SearchXml;
import com.netcracker.fileWorker.SearchXmlImpl;
import com.netcracker.fileWorker.XmlReaderWriter;
import com.netcracker.fileWorker.XmlReaderWriterImpl;
import com.netcracker.service.Service;
import com.netcracker.thread.NewThread;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.File;
import java.util.*;

public class Begin {
    public static Service service;
    private static File folder;
    private static List<File> fileList;
    private static boolean goOn = true;

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext context =
                new FileSystemXmlApplicationContext(
                        "src/resources/applicationContext.xml");
        service = (Service) context.getBean("service");

        while (goOn) {
            chatBot();
            if (goOn && fileList.size() > 0) {
                System.out.println("List of *.xml files:");

                createThreads();

            } else if (goOn) {
                System.out.println("There are no *.xml files. Do you want create?");
                Scanner in = new Scanner(System.in);
                if (in.nextLine().toLowerCase().equals("yes")) {
                    File newFile = new File(folder.getPath() + "/ramdom_xml.xml");
                    XmlReaderWriter xmlReaderWriter = new XmlReaderWriterImpl(newFile);
                    xmlReaderWriter.toXML();
                }
            }
        }
    }

    private static void createThreads() {
        for (File file : fileList) {
            System.out.println(file);
            new NewThread(file);
        }
    }

    private static void chatBot() {
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Please enter correct folder path:");
            folder = new File(in.nextLine());
            if (folder.getName().equals("end")) {
                goOn = false;
                return;
            }
        } while (!folder.exists());

        System.out.println("Do you to search all files inside the directory? (yes/no):");
        SearchXml searchXml = new SearchXmlImpl();
        if (in.nextLine().toLowerCase().equals("yes")) {
            fileList = searchXml.inAllFolders(folder);
        } else {
            fileList = searchXml.onlyInRootFolder(folder);
        }
    }
}