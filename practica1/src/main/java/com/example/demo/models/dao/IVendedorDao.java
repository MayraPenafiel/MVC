package com.example.demo.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Vendedor;

public interface IVendedorDao extends CrudRepository<Vendedor,Long>{

	
}
