package com.springboot.app.models.dao;

import com.springboot.app.models.entity.Producto;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProductoDao extends CrudRepository<Producto, Long> {
    @Query("select p from Producto p where p.nombre like %?1%")
    List<Producto> findByNombre(String term);

    List<Producto> findByNombreLikeIgnoreCase(String term);
}
