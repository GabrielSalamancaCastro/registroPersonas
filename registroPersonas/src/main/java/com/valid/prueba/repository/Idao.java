package com.valid.prueba.repository;

import java.util.List;

public interface Idao<T> {

    // ===== METODOS DE LA INTERFACE ==========
    void clear();
    T insertInto(T t);
    void delete(Integer id);
    T update(T t);
    T search(Integer id);
    List<T> searchAll();



}
