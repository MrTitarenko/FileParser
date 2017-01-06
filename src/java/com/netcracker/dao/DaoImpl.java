package com.netcracker.dao;

import com.netcracker.entity.Book;
import com.netcracker.entity.Customer;
import com.netcracker.entity.Film;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

import static com.netcracker.dao.Query.*;

@Repository
public class DaoImpl implements Dao {
    private static final Logger LOGGER = Logger.getLogger(DaoImpl.class);
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insertCustomer(List<Customer> сustomerList) {
        if (сustomerList.size() > 0) {
            for (Customer customer : сustomerList) {
                jdbcTemplate.update(INSERT_CUSTOMER, customer.getId(),
                        customer.getName(), customer.getAge());
            }
        }
        LOGGER.info("There are " + сustomerList.size() +
                " customers in " + Thread.currentThread().getName());
    }

    @Override
    public void insertBook(List<Book> bookList) {
        if (bookList.size() > 0) {
            for (Book book : bookList) {
                jdbcTemplate.update(INSERT_BOOK,
                        book.getId(), book.getAuthor(), book.getName(), book.getYear());
            }
        }
        LOGGER.info("There are " + bookList.size() +
                " books in " + Thread.currentThread().getName());
    }

    @Override
    public void insertFilm(List<Film> filmList) {
        if (filmList.size() > 0) {
            for (Film film : filmList) {
                jdbcTemplate.update(INSERT_FILM,
                        film.getId(), film.getName(), film.getGenre(), film.getBudget());
            }
        }
        LOGGER.info("There are " + filmList.size() +
                " films in " + Thread.currentThread().getName());
    }
}