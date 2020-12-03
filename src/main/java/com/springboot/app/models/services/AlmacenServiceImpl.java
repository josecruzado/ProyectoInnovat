package com.springboot.app.models.services;

import com.springboot.app.models.dao.IAlmacenDao;
import com.springboot.app.models.entity.Almacen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class AlmacenServiceImpl implements IAlmacenService {


    @Autowired
    private IAlmacenDao almacenDao;

    @Transactional(readOnly=true)
    @Override
    public Set<Almacen> findAll() {
        return (Set<Almacen>) almacenDao.findAll();
    }

    @Transactional(readOnly=true)
    @Override
    public void save(Almacen almacen) {
        almacenDao.save(almacen);
    }

    @Transactional
    @Override
    public Almacen findById(Long id) {
        return almacenDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        almacenDao.deleteById(id);
    }
}
