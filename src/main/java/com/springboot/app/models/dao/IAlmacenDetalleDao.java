package com.springboot.app.models.dao;

import com.springboot.app.models.entity.AlmacenDetalle;
import org.springframework.data.repository.CrudRepository;

public interface IAlmacenDetalleDao extends CrudRepository<AlmacenDetalle,Long> {
}
