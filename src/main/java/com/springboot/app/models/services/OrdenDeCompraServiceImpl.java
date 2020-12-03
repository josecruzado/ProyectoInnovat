package com.springboot.app.models.services;

import com.springboot.app.models.dao.IOrdenDeCompraDao;
import com.springboot.app.models.entity.OrdenDeCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class OrdenDeCompraServiceImpl implements IOrdenDeCompraService {
    @Autowired
    private IOrdenDeCompraDao ordenDeCompraDao;

    @Transactional(readOnly=true)
    @Override
    public List<OrdenDeCompra> findAll() {
        return (List<OrdenDeCompra>) ordenDeCompraDao.findAll();
    }

    @Transactional()
    @Override
    public void save(OrdenDeCompra ordenDeCompra) {
        ordenDeCompraDao.save(ordenDeCompra);
    }

    @Transactional
    @Override
    public OrdenDeCompra findById(Long id) {
        return ordenDeCompraDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        ordenDeCompraDao.deleteById(id);
    }
}
