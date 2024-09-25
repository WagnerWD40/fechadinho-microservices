package edu.infnet.jogador_service.service;

import java.util.List;
import java.util.Optional;

public interface ResourceService<T> {
    T create(T item);
    Optional<T> findById(Long id);
    List<T> findAll();
    void delete(Long id);
    T update(T item);
}