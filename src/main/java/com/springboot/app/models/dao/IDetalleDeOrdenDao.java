package com.springboot.app.models.dao;
import com.springboot.app.models.entity.DetalleDeOrden;
import org.springframework.data.repository.CrudRepository;

public interface IDetalleDeOrdenDao extends CrudRepository<DetalleDeOrden,Long> {
}
