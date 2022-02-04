package com.example.demo.models.service;

import java.util.List;

import com.example.demo.models.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente>findAll();
	
	public Cliente save(Cliente cliente);
	
	public Cliente findById(long id);
	
	public void delete (Long id);

}
