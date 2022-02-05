package com.example.demo.models.service;

import java.util.List;


import com.example.demo.models.entity.Producto;

public interface IProductoService {
	
	public List<Producto> findAll();
	
	public Producto save(Producto producto);
	
	public Producto findById(Long id);
	
	public void delete(Long id);

}
