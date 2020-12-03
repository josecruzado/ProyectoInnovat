package com.springboot.app.models.services;

import com.springboot.app.models.entity.Empleado;

import java.util.Set;

public interface IEmpleadoService {
    Set<Empleado> findAll();

    void save(Empleado empleado);

    //public Almacen FindOne(Long id); //Buscar uno

    Empleado findById(Long id);

    //public void delete(Long id);
    void deleteById(Long id);
}
