package com.example.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.dao.IVendedorDao;
import com.example.demo.models.entity.Vendedor;

@Service
public class VendedorService implements IVendedorService {
	
	@Autowired
	private IVendedorDao VendedorDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Vendedor> findAll() {
		
		return (List<Vendedor>) VendedorDao.findAll();
	}

	@Override
	@Transactional
	public Vendedor save(Vendedor vendedor) {
		
		return VendedorDao.save(vendedor);
	}

	@Override
	@Transactional(readOnly=true)
	public Vendedor findById(Long id) {
		
		return VendedorDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		VendedorDao.deleteById(id);
	}

}
