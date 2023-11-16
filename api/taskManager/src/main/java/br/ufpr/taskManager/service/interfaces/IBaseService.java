package br.ufpr.taskManager.service.interfaces;

import java.util.List;

public interface IBaseService<ID, T> {
    List<T> findAll();
    T findById(ID id);
    T create(T entity);
    T update(T entity);
    void delete(ID id);
}

