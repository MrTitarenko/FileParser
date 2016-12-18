package com.netcracker.entity;

import java.util.List;

/**
 * Created by titarenko on 16.12.2016.
 */

public interface Data {

    void setСustomerList(List<Customer> сustomerList);

    void setBookList(List<Book> bookList);

    void setFilmList(List<Film> filmList);

    List<Customer> getСustomerList();

    List<Book> getBookList();

    List<Film> getFilmList();
}
