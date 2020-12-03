package com.springboot.app.models.services;

import com.springboot.app.models.entity.Proveedor;
import java.util.Set;

public interface IProveedorService {
    Set<Proveedor> findAll();

    void save(Proveedor proveedor);

    //public Almacen FindOne(Long id); //Buscar uno

    Proveedor findById(Long id);

    //public void delete(Long id);
    void deleteById(Long id);

    Proveedor findByRuc(String ruc);
}
