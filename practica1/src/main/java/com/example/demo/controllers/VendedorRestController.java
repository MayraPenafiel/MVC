package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.Vendedor;
import com.example.demo.models.service.IVendedorService;



@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class VendedorRestController {

	@Autowired
	private IVendedorService vendedorService;
	
	//listar todos los vendedores
	@GetMapping("/vendedores")
	public List<Vendedor> index(){
		return vendedorService.findAll();
	}
	
	//buscar un vendedor por id
	@GetMapping("/vendedores/{id}")
	public Vendedor show(@PathVariable Long id) {
		return vendedorService.findById(id);
	}
		
	//guardar un vendedor
	@PostMapping("/vendedores")
	@ResponseStatus(HttpStatus.CREATED)
	public Vendedor create(@RequestBody Vendedor producto) {
		return vendedorService.save(producto);
	}
		
	//editar un vendedor
	@PutMapping("/vendedores/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Vendedor update(@RequestBody Vendedor producto, @PathVariable Long id) {
		Vendedor vendedorActual = vendedorService.findById(id);
		vendedorActual.setApellidos(vendedorActual.getApellidos());
		vendedorActual.setNombre(vendedorActual.getNombre());
		vendedorActual.setDireccion(vendedorActual.getDireccion());
		vendedorActual.setEmail(vendedorActual.getEmail());
		vendedorActual.setTelefono(vendedorActual.getTelefono());
		return vendedorService.save(vendedorActual);
	}
		
	//eliminar un vendedor
	@DeleteMapping("/vendedores/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		vendedorService.delete(id);
	}

}
