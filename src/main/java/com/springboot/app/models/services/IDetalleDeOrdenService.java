package com.springboot.app.models.services;

import com.springboot.app.models.entity.DetalleDeOrden;

import java.util.Set;

public interface IDetalleDeOrdenService {
    Set<DetalleDeOrden> findAll();

    void save(DetalleDeOrden detalleDeOrden);

    //public Almacen FindOne(Long id); //Buscar uno

    DetalleDeOrden findById(Long id);

    //public void delete(Long id);
    void deleteById(Long id);
}
