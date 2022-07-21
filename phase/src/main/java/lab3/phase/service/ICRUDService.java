package lab3.phase.service;

import lab3.phase.entity.Address;

import java.util.List;

public interface ICRUDService<T> {
    T createOrUpdate(T item);
    List<T> read();
    Boolean delete(int id);
}
