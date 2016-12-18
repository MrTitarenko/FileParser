package com.netcracker.fileWorker;

import com.netcracker.Begin;
import com.netcracker.dao.Dao;
import com.netcracker.entity.*;
import com.netcracker.podam.SimpleCreator;
import com.netcracker.service.Service;
import com.netcracker.service.ServiceImpl;
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

//    private static void setValues() {
//        List<Customer> customerList = new ArrayList<>(10);
//        Customer customer = new Customer();
//        customer.setId(111);
//        customer.setName("Joeee");
//        customer.setAge(27);
//        customerList.add(customer);
//        data.setСustomerList(customerList);
//
//        List<Book> bookList = new ArrayList<>(10);
//        for (int i = 0; i < 3; i++) {
//            Book book = new Book();
//            book.setId(222 + i * 10);
//            book.setAuthor("Stephen King");
//            book.setName("It" + i);
//            book.setYear(1986);
//            bookList.add(book);
//        }
//        data.setBookList(bookList);
//
//        List<Film> filmList = new ArrayList<>(10);
//        for (int i = 0; i < 3; i++) {
//            Film film = new Film();
//            film.setId(333 + i * 10);
//            film.setName("Terminator" + i);
//            film.setGenre("thriller");
//            film.setBudget(2.5);
//            filmList.add(film);
//        }
//        data.setFilmList(filmList);
//    }
}