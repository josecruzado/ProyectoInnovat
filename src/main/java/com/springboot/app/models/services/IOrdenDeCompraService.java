package com.springboot.app.models.services;

import com.springboot.app.models.entity.OrdenDeCompra;

import java.util.List;


public interface IOrdenDeCompraService {
    List<OrdenDeCompra> findAll();

    void save(OrdenDeCompra ordenDeCompra);

    OrdenDeCompra findById(Long id);

    void deleteById(Long id);
}
