package com.example.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.dao.IProductoDao;
import com.example.demo.models.entity.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoDao ProductoDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Producto> findAll() {
		
		return (List<Producto>) ProductoDao.findAll();
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
		
		return ProductoDao.save(producto);
	}

	@Override
	@Transactional(readOnly=true)
	public Producto findById(Long id) {
		
		return ProductoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		ProductoDao.deleteById(id);
	}

}
