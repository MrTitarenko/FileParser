package com.netcracker.dao;

import com.netcracker.entity.Book;
import com.netcracker.entity.Customer;
import com.netcracker.entity.Film;

import java.util.List;

public interface Dao {

    void insertCustomer(List<Customer> сustomerList);

    void insertBook(List<Book> bookList);

    void insertFilm(List<Film> filmList);
}
