package com.springboot.app.models.services;

import com.springboot.app.models.dao.IAlmacenDetalleDao;
import com.springboot.app.models.entity.AlmacenDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class AlmacenDetalleServiceImpl implements IAlmacenDetalleService {
    @Autowired
    private IAlmacenDetalleDao almacenDetalleDao;

    @Transactional(readOnly=true)
    @Override
    public Set<AlmacenDetalle> findAll() {
        return (Set<AlmacenDetalle>) almacenDetalleDao.findAll();
    }

    @Transactional(readOnly=true)
    @Override
    public void save(AlmacenDetalle almacenDetalle) {
        almacenDetalleDao.save(almacenDetalle);
    }

    @Transactional
    @Override
    public AlmacenDetalle findById(Long id) {
        return almacenDetalleDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        almacenDetalleDao.deleteById(id);
    }
}
