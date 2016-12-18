package com.netcracker.service;

import com.netcracker.dao.Dao;
import com.netcracker.entity.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Locale;

/**
 * Created by titarenko on 17.12.2016.
 */

public class ServiceImpl implements Service {

    private Dao dao;

    @Autowired
    ServiceImpl(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void saveData(Data data) {
        if (data != null) {
            dao.insertCustomer(data.getСustomerList());
            dao.insertBook(data.getBookList());
            dao.insertFilm(data.getFilmList());
        }
    }
}
