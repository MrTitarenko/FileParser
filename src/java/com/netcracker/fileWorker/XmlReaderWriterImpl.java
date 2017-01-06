package com.netcracker.fileWorker;

import com.netcracker.Begin;
import com.netcracker.dao.Dao;
import com.netcracker.entity.*;
import com.netcracker.podam.SimpleCreator;
import com.netcracker.service.Service;
import com.netcracker.service.ServiceImpl;
import com.sun.org.apache.xml.internal.serialize.LineSeparator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class XmlReaderWriterImpl implements XmlReaderWriter {
    private File file;
    private static Data data = new DataImpl();

    public XmlReaderWriterImpl(File file) {
        this.file = file;
    }

    @Override
    public synchronized void toXML() {
        SimpleCreator creator = new SimpleCreator();
        data = creator.setValues();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DataImpl.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);     //  Formatted output
            jaxbMarshaller.marshal(data, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void toObject() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DataImpl.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            data = (Data) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        Begin.service.saveData(data);
    }
}