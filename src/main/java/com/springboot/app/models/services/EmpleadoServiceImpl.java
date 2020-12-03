package com.springboot.app.models.services;

import com.springboot.app.models.dao.IEmpleadoDao;
import com.springboot.app.models.entity.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{
    @Autowired
    private IEmpleadoDao empleadoDao;

    @Transactional(readOnly=true)
    @Override
    public Set<Empleado> findAll() {
        return (Set<Empleado>) empleadoDao.findAll();
    }

    @Transactional(readOnly=true)
    @Override
    public void save(Empleado empleado) {
        empleadoDao.save(empleado);
    }

    @Transactional
    @Override
    public Empleado findById(Long id) {
        return empleadoDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        empleadoDao.deleteById(id);
    }
}
