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

import com.example.demo.models.entity.Empleado;
import com.example.demo.models.service.IEmpleadoService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class EmpleadoRestController {
	
	@Autowired
	private IEmpleadoService empleadoService;
	
	//listar todos los empleados
	@GetMapping("/empleados")
	public List<Empleado> index(){
		return empleadoService.findAll();
	}
	
	//buscar un empleado por id
	@GetMapping("/empleados/{id}")
	public Empleado show(@PathVariable Long id) {
		return empleadoService.findById(id);
	}
	
	//guardar un empleado
	@PostMapping("/empleados")
	@ResponseStatus(HttpStatus.CREATED)
	public Empleado create(@RequestBody Empleado empleado) {
		return empleadoService.save(empleado);
	}
	
	//editar un empleado
	@PutMapping("/empleados/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Empleado update(@RequestBody Empleado empleado, @PathVariable Long id) {
		Empleado empleadoActual = empleadoService.findById(id);
		empleadoActual.setApellido(empleado.getApellido());
		empleadoActual.setNombre(empleado.getNombre());
		empleadoActual.setCi(empleado.getCi());
		empleadoActual.setDireccion(empleadoActual.getDireccion());
		empleadoActual.setSexo(empleado.getSexo());
		empleadoActual.setSalario(empleado.getSalario());
		empleadoActual.setSuperci(empleado.getSuperci());
		empleadoActual.setDno(empleado.getDno());
		return empleadoService.save(empleadoActual);
	}
	
	//eliminar un empleado
		@DeleteMapping("/empleados/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void delete(@PathVariable Long id) {
			empleadoService.delete(id);
		}
}
