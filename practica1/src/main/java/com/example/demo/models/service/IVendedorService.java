package com.example.demo.models.service;

import java.util.List;

import com.example.demo.models.entity.Vendedor;

public interface IVendedorService {

	public List<Vendedor> findAll();
	
	public Vendedor save(Vendedor vendedor);
	
	public Vendedor findById(Long id);
	
	public void delete(Long id);
}
