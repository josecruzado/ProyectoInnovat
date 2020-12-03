package com.springboot.app.models.services;

import com.springboot.app.models.dao.IProveedorDao;
import com.springboot.app.models.entity.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class ProveedorServiceImpl implements IProveedorService{
    @Autowired
    private IProveedorDao proveedorDao;

    @Transactional(readOnly=true)
    @Override
    public Set<Proveedor> findAll() {
        return (Set<Proveedor>) proveedorDao.findAll();
    }

    @Transactional(readOnly=true)
    @Override
    public void save(Proveedor proveedor) {
        proveedorDao.save(proveedor);
    }

    @Transactional
    @Override
    public Proveedor findById(Long id) {
        return proveedorDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        proveedorDao.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Proveedor findByRuc(String ruc) {
        return proveedorDao.findByRucLikeIgnoreCase("%"+ruc+"%");
    }
}
