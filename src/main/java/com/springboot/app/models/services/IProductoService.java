package com.springboot.app.models.services;

import com.springboot.app.models.entity.Producto;

import java.util.List;
import java.util.Set;

public interface IProductoService {
    Set<Producto> findAll();

    Producto save(Producto producto);

    //public Almacen FindOne(Long id); //Buscar uno

    Producto findById(Long id);

    //public void delete(Long id);
    void deleteById(Long id);

    List<Producto> findByNombre(String term);
}
