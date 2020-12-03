package com.springboot.app.models.dao;

import com.springboot.app.models.entity.OrdenDeCompra;
import org.springframework.data.repository.CrudRepository;

public interface IOrdenDeCompraDao extends CrudRepository<OrdenDeCompra, Long> {

}
