package com.springboot.app.models.services;

import com.springboot.app.models.dao.IDetalleDeOrdenDao;
import com.springboot.app.models.entity.DetalleDeOrden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class DetalleDeOrdenServiceImpl implements IDetalleDeOrdenService {
    @Autowired
    private IDetalleDeOrdenDao detalleDeOrdenDao;

    @Transactional(readOnly=true)
    @Override
    public Set<DetalleDeOrden> findAll() {
        return (Set<DetalleDeOrden>) detalleDeOrdenDao.findAll();
    }

    @Transactional()
    @Override
    public void save(DetalleDeOrden detalleDeOrden) {
        detalleDeOrdenDao.save(detalleDeOrden);
    }

    @Transactional
    @Override
    public DetalleDeOrden findById(Long id) {
        return detalleDeOrdenDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        detalleDeOrdenDao.deleteById(id);
    }
}
