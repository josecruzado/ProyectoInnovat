package com.springboot.app.models.dao;

import com.springboot.app.models.entity.Proveedor;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface IProveedorDao extends CrudRepository<Proveedor,Long> {
    @Query("select p from Proveedor p where p.ruc = ?1")
    Proveedor findByRuc(String term);

    Proveedor findByRucLikeIgnoreCase(String term);
}
