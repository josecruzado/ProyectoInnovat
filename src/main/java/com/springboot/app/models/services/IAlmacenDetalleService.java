package com.springboot.app.models.services;
import com.springboot.app.models.entity.AlmacenDetalle;

import java.util.Set;


public interface IAlmacenDetalleService {
    Set<AlmacenDetalle> findAll();

    void save(AlmacenDetalle almacenDetalle);

    //public Almacen FindOne(Long id); //Buscar uno

    AlmacenDetalle findById(Long id);

    //public void delete(Long id);
    void deleteById(Long id);
}
