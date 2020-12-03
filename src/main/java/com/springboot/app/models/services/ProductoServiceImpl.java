package com.springboot.app.models.services;

import com.springboot.app.models.dao.IProductoDao;
import com.springboot.app.models.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class ProductoServiceImpl implements IProductoService{
    @Autowired
    private IProductoDao productoDao;

    @Transactional(readOnly=true)
    @Override
    public Set<Producto> findAll() {
        return (Set<Producto>) productoDao.findAll();
    }

    @Transactional(readOnly=true)
    @Override
    public Producto save(Producto producto) {
        productoDao.save(producto);
        return producto;
    }

    @Transactional
    @Override
    public Producto findById(Long id) {
        return productoDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        productoDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findByNombre(String term) {
        return productoDao.findByNombreLikeIgnoreCase("%"+term+"%");
    }
}
