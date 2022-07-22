package com.javokhir.lab3.controller;

import com.javokhir.lab3.service.CrudService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CrudController<T, ID> {

    CrudService<T, ID> getService();

    @GetMapping
    default List<T> getAll() {
        return getService().getAll();
    }

    @GetMapping("/{id}")
    default T getById(@PathVariable("id") ID id) {
        return getService().getById(id);
    }

    @PostMapping
    default T create(@RequestBody T dto) {
        return getService().create(dto);
    }

    @PutMapping
    default T update(@RequestBody T dto) {
        return getService().update(dto);
    }

    @DeleteMapping("/{id}")
    default void delete(@PathVariable("id") ID id) {
        getService().delete(id);
    }
}
