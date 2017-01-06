package com.netcracker.service;

import com.netcracker.dao.Dao;
import com.netcracker.entity.Data;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceImpl implements Service {

    private final Dao dao;

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
