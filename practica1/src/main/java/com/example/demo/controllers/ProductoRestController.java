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

import com.example.demo.models.entity.Producto;
import com.example.demo.models.service.IProductoService;
@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ProductoRestController {
	
	@Autowired
	private IProductoService productoService;
	
	//listar todos los productos
	@GetMapping("/productos")
	public List<Producto> index(){
		return productoService.findAll();
	}
	
	//buscar un producto por id
	@GetMapping("/productos/{id}")
	public Producto show(@PathVariable Long id) {
		return productoService.findById(id);
	}
		
	//guardar un producto
	@PostMapping("/productos")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto create(@RequestBody Producto producto) {
		return productoService.save(producto);
	}
		
		//editar un producto
		@PutMapping("/productos/{id}")
		@ResponseStatus(HttpStatus.CREATED)
		public Producto update(@RequestBody Producto producto, @PathVariable Long id) {
			Producto productoActual = productoService.findById(id);
			productoActual.setCosto(producto.getCosto());
			productoActual.setNombre(producto.getNombre());
			productoActual.setDescripcion(producto.getDescripcion());
			productoActual.setStock(productoActual.getStock());
			return productoService.save(productoActual);
		}
		
		//eliminar un producto
			@DeleteMapping("/productos/{id}")
			@ResponseStatus(HttpStatus.NO_CONTENT)
			public void delete(@PathVariable Long id) {
				productoService.delete(id);
			}

}
