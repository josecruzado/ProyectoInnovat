package com.springboot.app.models.services;

import com.springboot.app.models.entity.Almacen;

import java.util.Set;


public interface IAlmacenService {
    Set<Almacen> findAll();

    void save(Almacen almacen);

    //public Almacen FindOne(Long id); //Buscar uno

    Almacen findById(Long id);

    //public void delete(Long id);
    void deleteById(Long id);
}
