package com.javokhir.lab3.service;

import java.util.List;

public interface CrudService<T, ID> {

    T create(T dto);

    T update(T dto);

    List<T> getAll();

    T getById(ID id);

    void delete(ID id);
}
