package com.netcracker.entity;

import com.sun.org.apache.xml.internal.serialize.LineSeparator;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by titarenko on 16.12.2016.
 */

@XmlRootElement
@XmlType(propOrder = {"сustomerList", "bookList", "filmList"})
public class DataImpl implements Data {

    private List<Customer> сustomerList;
    private List<Book> bookList;
    private List<Film> filmList;

    @XmlElement(name = "Customer")
    @XmlElementWrapper
    public void setСustomerList(List<Customer> сustomerList) {
        this.сustomerList = сustomerList;
    }

    @XmlElement(name = "Book")
    @XmlElementWrapper
    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @XmlElement(name = "Film")
    @XmlElementWrapper
    public void setFilmList(List<Film> filmList) {
        this.filmList = filmList;
    }

    public List<Customer> getСustomerList() {
        return сustomerList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public List<Film> getFilmList() {
        return filmList;
    }

    @Override
    public String toString() {
        return "Data{" + LineSeparator.Windows +
                "сustomerList: " + сustomerList + LineSeparator.Windows +
                "bookList: " + bookList + LineSeparator.Windows +
                "filmList: " + filmList + LineSeparator.Windows +
                '}';
    }
}
