package com.example.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.dao.IEmpleadoDao;
import com.example.demo.models.entity.Empleado;

@Service
public class EmpleadoServiceImpl  implements IEmpleadoService{

	@Autowired
	private IEmpleadoDao EmpleadoDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Empleado> findAll() {
		
		return (List<Empleado>) EmpleadoDao.findAll();
	}

}
