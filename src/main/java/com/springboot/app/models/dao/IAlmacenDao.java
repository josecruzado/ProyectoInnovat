package com.springboot.app.models.dao;

import com.springboot.app.models.entity.Almacen;
import org.springframework.data.repository.CrudRepository;

public interface IAlmacenDao extends CrudRepository<Almacen,Long> {

}
