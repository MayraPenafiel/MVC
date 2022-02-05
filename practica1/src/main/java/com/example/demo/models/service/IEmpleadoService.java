package com.example.demo.models.service;

import java.util.List;

import com.example.demo.models.entity.Empleado;

public interface IEmpleadoService {
	
	public List<Empleado> findAll();
	
	public Empleado save(Empleado empleado);
	
	public Empleado findById(Long id);
	
	public void delete(Long id);
	
}
